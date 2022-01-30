package com.qr_storeage.QR_StoragePt2.Models.Locations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Locations must have a name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;

    @ManyToMany
    @JoinTable(
            name="location_item",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @JsonIgnoreProperties({"tote", "location"})
    private Set<Item> items;

    public Location() {
    }

    public Location(String name, Facility facility) {
        this.name = name;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
