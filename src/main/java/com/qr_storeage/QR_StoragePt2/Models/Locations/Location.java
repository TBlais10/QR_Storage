package com.qr_storeage.QR_StoragePt2.Models.Locations;

import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Item[] items;
    @ManyToOne
    private Facility facility;

    public Location() {
    }

    public Location(String name, Item[] items, Facility facility) {
        this.name = name;
        this.items = items;
        this.facility = facility;
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

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
