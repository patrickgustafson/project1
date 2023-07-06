package com.skillstorm.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Warehouse;
import com.skillstorm.project1.services.WarehouseService;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    WarehouseService service;

    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = service.findAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = service.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/warehouse")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse updatedWarehouse = service.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(updatedWarehouse, HttpStatus.OK);
    }

    @PutMapping("/warehouse/updateCapacity")
    public ResponseEntity<Integer> updateWarehouseCapacity(@RequestBody Warehouse warehouse, @RequestParam int newCapacity) {
        int updatedWarehouse = service.updateCapacity(warehouse, newCapacity);
        return new ResponseEntity<Integer>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable int id) {
        service.deleteWarehouse(id);
        return new ResponseEntity<Warehouse>(HttpStatus.NO_CONTENT);
    }
}
