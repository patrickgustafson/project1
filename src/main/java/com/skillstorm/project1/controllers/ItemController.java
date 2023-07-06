package com.skillstorm.project1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Item;
import com.skillstorm.project1.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    ItemService service;

    @GetMapping
    public ResponseEntity<List<Item>> findAllItems() {
        List<Item> items = service.findAllItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }


    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item createdItem = service.saveItem(item);
        return new ResponseEntity<Item>(createdItem, HttpStatus.CREATED);
    }
}
