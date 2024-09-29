package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Inventory;
import ru.spmi.winery.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllAvailableInventoryItems() {
        return inventoryRepository.findInventoryByBottlesAvailableGreaterThan(0);
    }

}
