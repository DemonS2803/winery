package ru.spmi.winery.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.entities.Order;
import ru.spmi.winery.services.BucketService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/bucket")
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @GetMapping("")
    public ResponseEntity<List<Bucket>> getUserBucket() {
        return ResponseEntity.ok(bucketService.getUserBucketItemsByName(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @PutMapping("/add/{batchId}")
    public ResponseEntity<?> addBatchToBucket(@PathVariable("batchId") Long batchId) {
//        Long userId = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        log.info("Add batch to backet: " + batchId);
//        log.info("Current user: " + SecurityContextHolder.getContext().getAuthentication().getDetails());
        bucketService.addBucketItemByUserName(SecurityContextHolder.getContext().getAuthentication().getName(), batchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buyBucketItems() {
        bucketService.buyBucketItems(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
