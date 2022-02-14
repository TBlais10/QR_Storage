package com.qr_storeage.QR_StoragePt2.Models.Locations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.qr_storeage.QR_StoragePt2.Models.Site.Site;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Locations must have a name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"developers", "locations"})
    public Site site;

    @ManyToMany
    @JoinTable(
            name="location_item",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
//    @JsonIgnoreProperties({"tote", "location"})
    @JsonIncludeProperties({"id", "name", "quantity"})
    public Set<Item> items;

    public Location() {
    }

    public Location(String name, Site site) {
        this.name = name;
        this.site = site;
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

}
