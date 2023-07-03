package com.skillstorm.project1.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.project1.models.Warehouse;

@Service
public class WarehouseService {
    
    public List<Warehouse> findAllWarehouses() {
        List<Warehouse> warehouses = new LinkedList<>();
        warehouses.add(new Warehouse(0, "Chicago", 100));
        warehouses.add(new Warehouse(1, "Los Angeles", 100));
        return warehouses;
    }

    public List<Warehouse> findWarehousesByLocation(String location) {
        List<Warehouse> warehouses = new LinkedList<>();
        warehouses.add(new Warehouse(0, location, 100));
        warehouses.add(new Warehouse(1, location, 100));
        return warehouses;
    }
}
