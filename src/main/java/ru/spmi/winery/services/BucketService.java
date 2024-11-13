package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.entities.embedded.BucketItemId;
import ru.spmi.winery.repositories.BatchRepository;
import ru.spmi.winery.repositories.BucketRepository;
import ru.spmi.winery.repositories.CustomerRepository;

import java.util.List;

@Service
public class BucketService {

    @Autowired
    private BucketRepository bucketRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<Bucket> getUserBucketItems(Long customerId) {
        return bucketRepository.findBucketsByCustomerId(customerId);
    }

    public Bucket addBucketItemByUserName(String userName, Long batchId) {
        Customer customer = customerRepository.findByEmail(userName);
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

}
