package com.qr_storeage.QR_StoragePt2.Models.Items;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private Location location;

    @NotBlank(message = "Item must have a name")
    private String name;
    private String description;
    private Long quantity;

    @NotBlank(message = "Condition of item must be given")
    private String cond; //condition of item

    private String type;
    private String color;
    private String serialNumber; //TODO: metaIdentifier - not specific .... identifier type? sql word? (RESEARCH IT)
    private Double price;
    //mac address??

    @OneToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private Avatar avatar;

    public Item() {
    }

    public Item(Location location, String name, String description, Long quantity, String cond, String type, String color, String serialNumber, Double price) {
        this.location = location;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.cond = cond;
        this.type = type;
        this.color = color;
        this.serialNumber = serialNumber;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
