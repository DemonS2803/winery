package ru.spmi.winery.entities.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class BucketItemId {

    private long customerId;
    private long position;

}
