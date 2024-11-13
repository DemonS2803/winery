package ru.spmi.winery.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.services.BucketService;

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
        return ResponseEntity.ok(bucketService.getUserBucketItems(1L));
    }

    @PutMapping("/add/{batchId}")
    public ResponseEntity<?> addBatchToBucket(@PathVariable("batchId") Long batchId) {
//        Long userId = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        log.info("Add batch to backet: " + batchId);
//        log.info("Current user: " + SecurityContextHolder.getContext().getAuthentication().getDetails());
        bucketService.addBucketItemByUserName(SecurityContextHolder.getContext().getAuthentication().getName(), batchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
