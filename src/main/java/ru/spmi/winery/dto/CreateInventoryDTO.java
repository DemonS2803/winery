package ru.spmi.winery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import ru.spmi.winery.entities.Batch;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInventoryDTO {

    private Integer bottles;
    private String wineName;
}
