package com.skillstorm.project1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project1.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    @Query("update Warehouse w set w.capacity = :new_capacity where id = :warehouse_id")
    @Modifying
    @Transactional
    public int updateWarehouseCapacity(@Param("warehouse_id") int id, @Param("new_capacity") int newCapacity);
}
