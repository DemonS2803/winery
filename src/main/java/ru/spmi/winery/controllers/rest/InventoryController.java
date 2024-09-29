package ru.spmi.winery.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spmi.winery.entities.Inventory;
import ru.spmi.winery.services.InventoryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/available")
    public ResponseEntity<List<Inventory>> getAvailableInventory() {
        return ResponseEntity.ok(inventoryService.getAllAvailableInventoryItems());
    }
}
