package com.skillstorm.project1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin("*")
public class WarehouseController {

    @Autowired
    WarehouseService service;

    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = service.findAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> findWarehouseById(int id) {
        Warehouse warehouse = service.findWarehouseById(id);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> createWarehouse(@Valid @RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = service.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/warehouse/{id}")
    public ResponseEntity<Integer> updateWarehouse(@RequestBody Warehouse warehouse,
                                                   @RequestParam(required = false) String newLocation,
                                                   @RequestParam(required = false) int newCapacity) {
        int updatedWarehouse = service.updateWarehouse(warehouse, newLocation, newCapacity);
        return new ResponseEntity<Integer>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> deleteWarehouse(@RequestBody Warehouse warehouse) {
        service.deleteWarehouse(warehouse);
        return ResponseEntity.noContent().build();
    }
}
