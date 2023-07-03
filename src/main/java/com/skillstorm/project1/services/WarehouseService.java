package com.skillstorm.project1.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project1.dtos.WarehouseDto;
import com.skillstorm.project1.mappers.WarehouseMapper;
import com.skillstorm.project1.models.Warehouse;
import com.skillstorm.project1.repositories.WarehouseRepository;

@Service
public class WarehouseService {

    //@Autowired
    //WarehouseRepository repository;

    @Autowired
    WarehouseMapper mapper;
    
    public List<WarehouseDto> findAllWarehouses() {
        List<Warehouse> warehouses = new LinkedList<>();
        warehouses.add(new Warehouse(0, "Chicago", 100));
        warehouses.add(new Warehouse(1, "Los Angeles", 100));

        List<WarehouseDto> warehouseDtos = warehouses.stream().map(mapper::toDto).collect(Collectors.toList());
        return warehouseDtos;
    }

    public List<Warehouse> findWarehousesByLocation(String location) {
        List<Warehouse> warehouses = new LinkedList<>();
        warehouses.add(new Warehouse(0, location, 100));
        warehouses.add(new Warehouse(1, location, 100));
        return warehouses;
    }

    public Warehouse findById(int id) {
        return new Warehouse(id, "New York", 50);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        warehouse.setId(1);
        return warehouse;
    }

    public Warehouse updateWarehouse(int id, Warehouse warehouse) {
        warehouse.setId(id);
        return warehouse;
    }

    public Warehouse deleteWarehouse(int id, Warehouse warehouse) {
        return warehouse;
    }
}
