package com.skillstorm.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Stock;
import com.skillstorm.project1.repositories.StockRepository;
import com.skillstorm.project1.services.StockService;
import com.skillstorm.project1.services.WarehouseService;
import com.skillstorm.project1.services.ItemService;

@RestController
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockController {
    
    @Autowired
    StockService stockService;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    WarehouseService warehouseService;

    // Gets all Stock
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStock() {
        
        List<Stock> stock = stockService.findAllStock();
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    // Gets Stock by Item and Warehouse Ids
    @GetMapping("/{itemId}/{warehouseId}")
    public ResponseEntity<Stock> findStockByIds(@PathVariable int itemId, @PathVariable int warehouseId) {

        Stock stock = stockService.findStockByIds(itemId, warehouseId);
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }

    // Gets Stock by Warehouse Id Only
    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Stock>> getStockByWarehouse(@PathVariable int warehouseId) {

        List<Stock> stocks = stockService.findStockByWarehouse(warehouseId);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    // Gets Stock by Item Id Only
    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<Stock>> getStockByItem(@PathVariable int itemId) {

        List<Stock> stocks = stockService.findStockByItem(itemId);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    // Creates new Stock
    @PostMapping
    public ResponseEntity<Stock> createStock(
            @RequestParam("itemId") int itemId,
            @RequestParam("warehouseId") int warehouseId,
            @RequestParam("quantity") int quantity) {

        Stock stock = stockService.createStock(itemId, warehouseId, quantity);
        return new ResponseEntity<Stock>(stock, HttpStatus.CREATED);
    }

    // Deletes Stock by Item and Warehouse Ids
    @DeleteMapping("/{itemId}/{warehouseId}")
    public ResponseEntity<Integer> deleteStock(@PathVariable int itemId,
            @PathVariable int warehouseId) {

        int deletedStock = stockService.deleteStock(itemId, warehouseId);
        return new ResponseEntity<Integer>(deletedStock, HttpStatus.OK);
    }

    // Updates Stock
    @PutMapping("/{itemId}/{warehouseId}/{quantity}")
    public ResponseEntity<Integer> updateStock(@PathVariable int itemId,
            @PathVariable int warehouseId,
            @PathVariable(required = false) int quantity) {

        int updatedStock = stockService.updateStock(itemId, warehouseId, quantity);
        return new ResponseEntity<Integer>(updatedStock, HttpStatus.OK);
    }
}
