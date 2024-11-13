package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import ru.spmi.winery.dto.CreateInventoryDTO;
import ru.spmi.winery.entities.Inventory;
import ru.spmi.winery.repositories.InventoryRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllAvailableInventoryItems() {
        return inventoryRepository.findInventoryByBottlesAvailableGreaterThan(0);
    }

    public Inventory createNewInventoryItem(CreateInventoryDTO dto) {
        Inventory inventory = Inventory.builder()
                .bottlesTotal(dto.getBottles())
                .bottlesAvailable(dto.getBottles())
                .lastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .batch(dto.getBatch())
                .build();
        inventoryRepository.save(inventory);
        return inventory;
    }

    public void updateInventoryItem(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

}
