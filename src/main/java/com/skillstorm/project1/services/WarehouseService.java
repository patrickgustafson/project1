package com.skillstorm.project1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project1.models.Warehouse;
import com.skillstorm.project1.repositories.WarehouseRepository;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository repository;

    @PersistenceContext
    private EntityManager EntityManager;
    
    public List<Warehouse> findAllWarehouses() {
        return repository.findAll();
    }

    public Warehouse findWarehouseById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Warehouse with id: " + id + "does not exist"));
    }

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @Transactional
    public int updateWarehouse(Warehouse warehouse, String newLocation, int newCapacity) {
        Optional<Warehouse> existingWarehouseOption = repository.findById(warehouse.getWarehouseId());
        if (!existingWarehouseOption.isPresent()) {
            throw new EntityNotFoundException("Warehouse with id: " + warehouse.getWarehouseId() + " does not exist");
        }

        Warehouse existingWarehouse = existingWarehouseOption.get();

        if (newLocation != null) {
            existingWarehouse.setLocation(newLocation);
        }
        if (newCapacity > 0) {
            existingWarehouse.setCapacity(newCapacity);
        }
        else {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        repository.save(existingWarehouse);
        return 1;
    }

    public Warehouse deleteWarehouse(Warehouse warehouse) {
        Optional<Warehouse> warehouseOption = repository.findById(warehouse.getWarehouseId());
        if (!warehouseOption.isPresent()) {
            throw new EntityNotFoundException("Warehouse with id: " + warehouse.getWarehouseId() + " does not exist");
        }
        repository.delete(warehouse);
        return warehouse;
    }
}
