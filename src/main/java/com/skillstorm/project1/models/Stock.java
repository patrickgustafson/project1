package com.skillstorm.project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int item_id;

    @Column
    private int warehouse_id;

    @Column
    private int quantity;

    public Stock(int id, int item_id, int warehouse_id, int quantity) {
        this.id = id;
        this.item_id = item_id;
        this.warehouse_id = warehouse_id;
        this.quantity = quantity;
    }

    public Stock(int item_id, int warehouse_id, int quantity) {
        this.item_id = item_id;
        this.warehouse_id = warehouse_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + item_id;
        result = prime * result + warehouse_id;
        result = prime * result + quantity;
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
        Stock other = (Stock) obj;
        if (id != other.id)
            return false;
        if (item_id != other.item_id)
            return false;
        if (warehouse_id != other.warehouse_id)
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", item_id=" + item_id + ", warehouse_id=" + warehouse_id + ", quantity=" + quantity
                + "]";
    }

    
    
}
