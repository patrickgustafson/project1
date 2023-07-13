package com.skillstorm.project1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.skillstorm.project1.models.Item;
import com.skillstorm.project1.models.Stock;
import com.skillstorm.project1.models.StockId;
import com.skillstorm.project1.models.Warehouse;
import com.skillstorm.project1.repositories.StockRepository;

@Service
public class StockService {

    @Autowired
    StockRepository repository;

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ItemService itemService;

    public List<Stock> findAllStock() {

        try {
            return repository.findAll();
            
        } catch (Exception e) {
            throw new EntityNotFoundException("There is no stock");
        }
    }

    public Stock findStockByIds(int itemId, int warehouseId) {
        StockId stockId = new StockId(itemId, warehouseId);
        Optional<Stock> stockOption = repository.findById(stockId);

        if (!stockOption.isPresent()) {
            throw new EntityNotFoundException("Stock with " + stockId + " does not exist.");
        }

        return repository.findById(stockId).get();
    }

    public List<Stock> findStockByWarehouse(int warehouseId) {
        Optional<List<Stock>> stockOption = repository.findByWarehouse(warehouseService.findWarehouseById(warehouseId));

        if (!stockOption.isPresent()) {
            throw new EntityNotFoundException("No stock for warehouse with id: " + warehouseId + " was found");
        }
        return stockOption.get();
    }

    public List<Stock> findStockByItem(int itemId) {
        Optional<List<Stock>> stockOption = repository.findByItem(itemService.findItemById(itemId));

        if (!stockOption.isPresent()) {
            throw new EntityNotFoundException("No Stock for item with id: " + itemId + " was found");
        }

        return stockOption.get();
    }

    @Transactional
    public Stock createStock(int itemId, int warehouseId, int quantity) {
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        Item item = itemService.findItemById(itemId);

        int currentCapacity = warehouse.getCapacity();
        int newCapacity = currentCapacity - quantity;

        if (newCapacity < 0) {
            throw new DataIntegrityViolationException("Stock quantity exceeds warehouse capacity");
        }

        warehouseService.updateCapacity(warehouse, newCapacity);

        Stock stock = new Stock();
        StockId stockId = new StockId();
        stockId.setItemId(itemId);
        stockId.setWarehouseId(warehouseId);
        stock.setId(stockId);
        stock.setItem(item);
        stock.setWarehouse(warehouse);
        stock.setQuantity(quantity);

        return repository.save(stock);
    }

    @Transactional
    public int deleteStock(int itemId, int warehouseId) {
        Optional<Stock> stockOption = repository.findById(findStockByIds(itemId, warehouseId).getId());
        if (!stockOption.isPresent()) {
            throw new EntityNotFoundException("Stock with id: " + findStockByIds(itemId, warehouseId).getId() + " does not exist");
        }

        Stock stock = stockOption.get();
        
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        int quantity = stock.getQuantity();
        int currentCapacity = warehouse.getCapacity();
        int newCapacity = currentCapacity + quantity;

        warehouseService.updateCapacity(warehouse, newCapacity);

        repository.delete(stock);

        return 1;
    }

    @Transactional
    public int updateStock(int itemId, int warehouseId, int quantity) {

        Optional<Stock> stockOption = repository.findById(findStockByIds(itemId, warehouseId).getId());
        if (!stockOption.isPresent()) {
            throw new EntityNotFoundException("Stock with id: " + findStockByIds(itemId, warehouseId).getId() + " does not exist");
        }

        Stock existingStock = stockOption.get();

        Item item = itemService.findItemById(itemId);
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);

        if (item != null) {
            existingStock.setItem(item);
        }
        if (warehouse != null) {
            existingStock.setWarehouse(warehouse);
        }
        if (quantity != 0) {
            int currentQuantity = existingStock.getQuantity();
            int quantityDifference = quantity - currentQuantity;
            int currentCapacity = existingStock.getWarehouse().getCapacity();
            int newCapacity = currentCapacity - quantityDifference;

            if (newCapacity < 0) {
                throw new DataIntegrityViolationException("Stock quantity exceeds warehouse capacity");
            }

            warehouseService.updateCapacity(existingStock.getWarehouse(), newCapacity);

            existingStock.setQuantity(quantity);
        } 
        else if (quantity == 0) {
            throw new DataIntegrityViolationException("Quantity cannot be 0");
        }
        return 1;
    }
}
