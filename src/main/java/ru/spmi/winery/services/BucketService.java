package ru.spmi.winery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.entities.Order;
import ru.spmi.winery.entities.OrderPosition;
import ru.spmi.winery.entities.embedded.BucketItemId;
import ru.spmi.winery.enums.OrderStatus;
import ru.spmi.winery.repositories.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
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

        Order order = Order.builder()
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .customer(customer)
                .status(OrderStatus.IN_PROGRESS)
                .shippingAddress("brrrrr")
                .totalPrice(buckets.stream().mapToDouble(b -> b.getCount() * b.getBatch().getPrice()).sum())
                .build();

        Order savedOrder = orderRepository.save(order);

        List<OrderPosition> orderPositions = buckets.stream().map(bucket -> {
            return new OrderPosition(bucket, order);
        }).collect(Collectors.toList());



        bucketRepository.deleteAll(buckets);

        return orderPositionRepository.saveAll(orderPositions);
    }

}
