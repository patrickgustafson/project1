package com.skillstorm.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project1.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    
}
