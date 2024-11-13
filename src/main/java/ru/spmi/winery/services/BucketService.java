package ru.spmi.winery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.*;
import ru.spmi.winery.entities.embedded.BucketItemId;
import ru.spmi.winery.enums.OrderStatus;
import ru.spmi.winery.repositories.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BucketService {

    @Autowired
    private BucketRepository bucketRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderPositionRepository orderPositionRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Bucket> getUserBucketItemsByName(String username) {
        Customer customer = customerRepository.findByEmail(username);
        log.info("Get user bucket items by customer: " + customer);
        return bucketRepository.findBucketsByCustomerId(customer.getId());
    }

    public List<Bucket> getUserBucketItems(Long customerId) {
        return bucketRepository.findBucketsByCustomerId(customerId);
    }

    public Bucket addBucketItemByUserName(String userName, Long batchId) {
        Customer customer = customerRepository.findByEmail(userName);
        log.info("customer {}", customer);
        return addBucketItem(customer.getId(), batchId);
    }


    public Bucket addBucketItem(Long customerId, Long batchId) {
        List<Bucket> buckets = getUserBucketItems(customerId);
        for (Bucket bucket : buckets) {
            if (bucket.getBatch().getId().equals(batchId)) {
                bucket.setCount(bucket.getCount() + 1);
                return bucketRepository.save(bucket);
            }
        }
        Bucket bucket = Bucket.builder()
                .id(new BucketItemId(customerId, buckets.size()))
                .count(1)
                .batch(batchRepository.getReferenceById(batchId))
                .build();
        return bucketRepository.save(bucket);

    }

    public List<OrderPosition> buyBucketItems(String login) {
        Customer customer = customerRepository.findByEmail(login);
        List<Bucket> buckets = bucketRepository.findBucketsByCustomerId(customer.getId());
        List<Order> orders = orderRepository.findAll();
        List<Inventory> inventories = inventoryRepository.findAll();

        Order order = Order.builder()
                .id(Long.valueOf(orders.size()) + 1)
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .customer(customer)
                .status(OrderStatus.IN_PROGRESS)
                .shippingAddress("brrrrr")
                .totalPrice(buckets.stream().mapToDouble(b -> b.getCount() * b.getBatch().getPrice()).sum())
                .build();


        Map<Long, Integer> batchCountMap = new HashMap<>();

        List<OrderPosition> orderPositions = buckets.stream().map(bucket -> {
            batchCountMap.put(bucket.getBatch().getId(), bucket.getCount());
            return new OrderPosition(bucket, order);
        }).collect(Collectors.toList());

        inventories = inventories.stream().peek(inventory -> inventory.setBottlesAvailable(inventory.getBottlesAvailable() - batchCountMap.getOrDefault(inventory.getBatch().getId(), 0))).collect(Collectors.toList());
        inventories.stream().peek(inventory -> {
            if (inventory.getBottlesAvailable() < 0) {
                throw new RuntimeException("no enough bottles available");
            }
        });
        inventoryRepository.saveAll(inventories);
        bucketRepository.deleteAll(buckets);
        Order savedOrder = orderRepository.save(order);
        return orderPositionRepository.saveAll(orderPositions);
    }

    public List<Order> getOrder(String login) {
        Customer customer = customerRepository.findByEmail(login);
        return orderRepository.findAll().stream().filter(order -> order.getCustomer().getId().equals(customer.getId())).collect(Collectors.toList());
    }

}
