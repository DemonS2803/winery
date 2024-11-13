package ru.spmi.winery.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.enums.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp created;
    @ManyToOne
    private Customer customer;
    private Double totalPrice;
    private String shippingAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
