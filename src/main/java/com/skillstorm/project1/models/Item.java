package com.skillstorm.project1.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column
    private String name;

    @Column
    private int units;

    @JsonBackReference
    @OneToMany(targetEntity = Stock.class, mappedBy = "item")
    private List<Stock> stock;

    public Item() {}

    public Item(int id, String name, int unitsPerItem) {
        this.itemId = id;
        this.name = name;
        this.units = unitsPerItem;
    }

    public Item(String name, int unitsPerItem) {
        this.name = name;
        this.units = unitsPerItem;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int id) {
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int unitsPerItem) {
        this.units = unitsPerItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + units;
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
        Item other = (Item) obj;
        if (itemId != other.itemId)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (units != other.units)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [id=" + itemId + ", name=" + name + ", unitsPerItem=" + units + "]";
    }
}
