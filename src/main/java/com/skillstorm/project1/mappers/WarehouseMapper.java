package com.skillstorm.project1.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.project1.dtos.WarehouseDto;
import com.skillstorm.project1.models.Warehouse;

@Component
public class WarehouseMapper {
    public Warehouse toWarehouse(WarehouseDto dto) {
        return new Warehouse(dto.getId(), dto.getLocation(), dto.getCapactity());
    }

    public WarehouseDto toDto(Warehouse warehouse) {
        return new WarehouseDto(warehouse.getWarehouseId(), warehouse.getLocation(), warehouse.getCapacity());
    }
}
