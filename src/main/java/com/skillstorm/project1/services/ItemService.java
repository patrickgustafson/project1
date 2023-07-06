package com.skillstorm.project1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project1.models.Item;

import com.skillstorm.project1.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> findAllItems() {
        return repository.findAll();
    }

    public Item findItemById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id: " + id + " does not exist"));
    }

    public Item saveItem(Item item) {
        return repository.save(item);
    }

    @Transactional
    public int updateItem(Item item, String newName, int newUnits) {
        Optional<Item> existingItemOption = repository.findById(item.getItemId());
        if (!existingItemOption.isPresent()) {
            throw new EntityNotFoundException("Item with id: " + item.getItemId() + " does not exist");
        }

        Item existingItem = existingItemOption.get();

        if (newName != null) {
            existingItem.setName(newName);
        }
        if (newUnits >= 0) {
            existingItem.setUnits(newUnits);
        }
        else {
            throw new IllegalArgumentException("Units must be 0 or more");
        }
        repository.save(existingItem);
        return 1;
    }

    public Item deleteItem(Item item) {
        Optional<Item> itemOption = repository.findById(item.getItemId());
        if (!itemOption.isPresent()) {
            throw new EntityNotFoundException("Item with id: " + item.getItemId() + " does not exist");
        }
        repository.delete(item);
        return item;
    }
}
