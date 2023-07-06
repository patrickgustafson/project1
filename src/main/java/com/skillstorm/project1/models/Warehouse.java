package com.skillstorm.project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @Column(name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouseId;

    @Column
    private String location;

    @Column
    private int capacity;

    @JsonBackReference
    @OneToMany(targetEntity = Stock.class, mappedBy = "warehouse")
    private List<Stock> stock;

    public Warehouse() {}

    public Warehouse(int id, String location, int capacity) {
        this.warehouseId = id;
        this.location = location;
        this.capacity = capacity;
    }

    public Warehouse(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int id) {
        this.warehouseId = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + warehouseId;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + capacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Warehouse other = (Warehouse) obj;
        if (warehouseId != other.warehouseId)
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (capacity != other.capacity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Warehouse [id=" + warehouseId + ", location=" + location + ", capacity=" + capacity + "]";
    } 
}
