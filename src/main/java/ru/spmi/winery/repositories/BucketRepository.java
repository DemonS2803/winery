package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Bucket;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.entities.embedded.BucketItemId;

import java.util.List;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, BucketItemId> {

    @Query(nativeQuery = true, value = "select customer_id, batch_id, position, count  from customer_bucket_items where customer_id = ?1")
    List<Bucket> findBucketsByCustomerId(Long customerId);

}
