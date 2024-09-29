package ru.spmi.winery.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.entities.embedded.BucketItemId;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "customer_bucket_items")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {

    @EmbeddedId
    private BucketItemId id;
    private Integer count;
    @ManyToOne
    private Batch batch;
}
