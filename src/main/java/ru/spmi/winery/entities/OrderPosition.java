package ru.spmi.winery.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.entities.embedded.OrderBatchId;

@Data
@Entity
@Builder
@Table(name = "order_positions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class OrderPosition {

    @EmbeddedId
    private OrderBatchId orderBatchId;
    private Integer count;
    private Double price;
    private Integer position;

    public OrderPosition(Bucket bucket, Order order) {
        this.orderBatchId = new OrderBatchId(bucket.getBatch().getId(), order.getId());
        this.count = bucket.getCount();
        this.position = Math.toIntExact(bucket.getId().getPosition());
        this.price = bucket.getBatch().getPrice();

    }

}
