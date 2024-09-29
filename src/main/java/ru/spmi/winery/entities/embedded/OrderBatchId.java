package ru.spmi.winery.entities.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderBatchId {

    private Long orderId;
    private Long batchId;

}
