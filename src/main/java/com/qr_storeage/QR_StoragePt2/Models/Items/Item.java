package com.qr_storeage.QR_StoragePt2.Models.Items;

import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinColumn(name="facility_id", referencedColumnName = "id")
    private Location location;

    private String name;
    private String description;
    private Long quantity;
    private String cond; //condition of item

    public Item() {
    }

    public Item(String name, String description, Long quantity, String cond) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.cond = cond;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
