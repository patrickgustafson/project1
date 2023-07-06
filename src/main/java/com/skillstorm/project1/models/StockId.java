package com.skillstorm.project1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StockId implements Serializable {

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "warehouse_id")
    private int warehouseId;

    public StockId() {}

    public StockId(int itemId, int warehouseId) {
        this.itemId = itemId;
        this.warehouseId = warehouseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + warehouseId;
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
        StockId other = (StockId) obj;
        if (itemId != other.itemId)
            return false;
        if (warehouseId != other.warehouseId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "StockId [itemId=" + itemId + ", warehouseId=" + warehouseId + "]";
    }
}
