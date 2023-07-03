package com.skillstorm.project1.dtos;

public class WarehouseDto {
    private int id;
    private String location;
    private int capactity;

    public WarehouseDto(int id, String location, int capactity) {
        this.id = id;
        this.location = location;
        this.capactity = capactity;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCapactity() {
        return capactity;
    }
    public void setCapactity(int capactity) {
        this.capactity = capactity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + capactity;
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
        WarehouseDto other = (WarehouseDto) obj;
        if (id != other.id)
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (capactity != other.capactity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WarehouseDto [id=" + id + ", location=" + location + ", capactity=" + capactity + "]";
    } 
}
