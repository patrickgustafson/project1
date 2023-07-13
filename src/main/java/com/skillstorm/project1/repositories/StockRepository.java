package com.skillstorm.project1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project1.models.Item;
import com.skillstorm.project1.models.Stock;
import com.skillstorm.project1.models.StockId;
import com.skillstorm.project1.models.Warehouse;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<Stock> findById(StockId id);

    Optional<List<Stock>> findByWarehouse(Warehouse warehouseId);

    Optional<List<Stock>> findByItem(Item item);
}
