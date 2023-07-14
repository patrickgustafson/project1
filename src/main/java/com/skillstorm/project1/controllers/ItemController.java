package com.skillstorm.project1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Item;
import com.skillstorm.project1.services.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin("*")
public class ItemController {
    
    @Autowired
    ItemService service;

    // Gets all Items
    @GetMapping
    public ResponseEntity<List<Item>> findAllItems() {
        List<Item> items = service.findAllItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    // Gets Item by Id
    @GetMapping("/item/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = service.findItemById(id);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    // Creates new Item
    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item createdItem = service.saveItem(item);
        return new ResponseEntity<Item>(createdItem, HttpStatus.CREATED);
    }

    // Updates Item using Id
    @PutMapping("/item/{id}")
    public ResponseEntity<Integer> updateItem(@RequestBody Item item,
                                              @RequestParam(required = false) String newName,
                                              @RequestParam(required = false) int newUnits) {
        int updatedItem = service.updateItem(item, newName, newUnits);
        return new ResponseEntity<Integer>(updatedItem, HttpStatus.OK);
    }

    // Deletes Item by Id
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Item> deleteItem(@RequestBody Item item) {
        service.deleteItem(item);
        return ResponseEntity.noContent().build();
    }
}
