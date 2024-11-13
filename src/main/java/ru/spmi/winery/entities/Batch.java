package ru.spmi.winery.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.enums.BottleType;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@Table(name = "batches")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Wine wine;
    private Timestamp fillDate;
    private Double volume;
    @Enumerated(EnumType.STRING)
    private BottleType bottle;
    private Double price;

}
