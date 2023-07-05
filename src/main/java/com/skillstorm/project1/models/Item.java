package com.skillstorm.project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "units_per_item")
    private int unitsPerItem;

    private Warehouse warehouse;

    public Item(int id, String name, int unitsPerItem) {
        this.id = id;
        this.name = name;
        this.unitsPerItem = unitsPerItem;
    }

    public Item(String name, int unitsPerItem) {
        this.name = name;
        this.unitsPerItem = unitsPerItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitsPerItem() {
        return unitsPerItem;
    }

    public void setUnitsPerItem(int unitsPerItem) {
        this.unitsPerItem = unitsPerItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + unitsPerItem;
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
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (unitsPerItem != other.unitsPerItem)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", unitsPerItem=" + unitsPerItem + "]";
    }
}
