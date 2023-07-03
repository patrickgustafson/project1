package com.skillstorm.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Warehouse> findAllWarehouses() {
        return service.findAllWarehouses();
    }
    
}
