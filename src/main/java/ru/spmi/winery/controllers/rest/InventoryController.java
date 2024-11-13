package ru.spmi.winery.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spmi.winery.dto.CreateInventoryDTO;
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

    @PostMapping("")
    public ResponseEntity<Inventory> createInventory(@RequestBody CreateInventoryDTO dto) {
        inventoryService.createNewInventoryItem(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
        inventoryService.updateInventoryItem(inventory);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
