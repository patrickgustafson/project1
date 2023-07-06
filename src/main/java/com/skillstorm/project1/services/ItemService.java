package com.skillstorm.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillstorm.project1.models.Item;

import com.skillstorm.project1.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> findAllItems() {
        return repository.findAll();
    }

    public Item saveItem(Item item) {
        return repository.save(item);
    }
}
