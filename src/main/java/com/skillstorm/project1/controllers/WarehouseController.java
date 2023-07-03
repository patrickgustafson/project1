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

import com.skillstorm.project1.dtos.WarehouseDto;
import com.skillstorm.project1.models.Warehouse;
import com.skillstorm.project1.services.WarehouseService;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    WarehouseService service;

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping
    public List<WarehouseDto> findAllWarehouses() {
        return service.findAllWarehouses();
    }

    @GetMapping("/location")
    public List<Warehouse> findByLocation(@RequestParam String location) {
        return service.findWarehousesByLocation(location);
    }  

    @GetMapping("/warehouse/{id}") 
    public Warehouse findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = service.createWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
        Warehouse updatedWarehouse = service.updateWarehouse(id, warehouse);
        return new ResponseEntity<Warehouse>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
        service.deleteWarehouse(id, warehouse);
        return new ResponseEntity<Warehouse>(HttpStatus.NO_CONTENT);
    }
}
