package ru.spmi.winery.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.enums.WineType;

@Data
@Entity
@Builder
@Table(name = "wines")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Double alcoholPercent;
    @Enumerated(EnumType.STRING)
    private WineType type;
    @ManyToOne
    private GrapeSort sort;
    @ManyToOne
    private Winery winery;

}
