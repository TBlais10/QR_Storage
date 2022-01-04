package com.qr_storeage.QR_StoragePt2.Models.Locations;

import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private Facility facility;

    @ManyToMany
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private List<Item> items;

    @ManyToMany
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private List<SalesItem> salesItems;

    public Location() {
    }

    public Location(String name, Facility facility, List<Item> items, List<SalesItem> salesItems) {
        this.name = name;
        this.facility = facility;
        this.items = items;
        this.salesItems = salesItems;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
