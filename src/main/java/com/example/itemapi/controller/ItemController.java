package com.example.itemapi.controller;

import com.example.itemapi.model.Item;
import com.example.itemapi.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Add new item
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        // Input Validation
        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Item name is required");
        }

        if (item.getPrice() <= 0) {
            return ResponseEntity.badRequest().body("Price must be greater than 0");
        }

        Item savedItem = itemService.addItem(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/")
    public String home() {
        return "Item API is running successfully!";
    }


    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {

        return itemService.getItemById(id)
                .map(item -> ResponseEntity.ok(item))
                .orElse(ResponseEntity.notFound().build());
    }
}
