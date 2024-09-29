package ru.spmi.winery.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.services.BucketService;

import java.util.List;

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

}
