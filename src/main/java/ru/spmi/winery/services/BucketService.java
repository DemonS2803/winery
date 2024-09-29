package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.repositories.BucketRepository;

import java.util.List;

@Service
public class BucketService {

    @Autowired
    private BucketRepository bucketRepository;

    public List<Bucket> getUserBucketItems(Long customerId) {
        return bucketRepository.findBucketsByCustomerId(customerId);
    }

}
