package com.qr_storeage.QR_StoragePt2.Models.Items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import com.qr_storeage.QR_StoragePt2.Models.Totes.Tote;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name="location_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    @JsonIgnoreProperties({"site" , "id"})
    public Set<Location> location;


    @NotBlank(message = "Item must have a name")
    private String name;
    private String description;
    private HashSet<String> tags;
    private Long quantity;

    @NotNull(message = "Condition of item must be given")
//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "item_condition",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "condition_id"))
    private ECond cond; //condition of item

//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "item_status",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "status_id"))
    private EStatus status;

//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "item_locations",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "locationTag_id"))
    private ELocationTag locationTag;

    private String type;
    private String color;
    private String serialNumber; //TODO: metaIdentifier - not specific .... identifier type? sql word? (RESEARCH IT)
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private Avatar avatar;


    @ManyToOne
    @JsonIgnore
    private Tote tote;

    public Item() {
    }

    public Item(String name, String description, Long quantity, ECond cond, EStatus status, ELocationTag locationTag, String type, String color, String serialNumber, BigDecimal price, Avatar avatar) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.cond = cond;
        this.status = status;
        this.locationTag = locationTag;
        this.type = type;
        this.color = color;
        this.serialNumber = serialNumber;
        this.price = price;
        this.avatar = avatar;
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

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ECond getCond() {
        return cond;
    }

    public void setCond(ECond cond) {
        this.cond = cond;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public Set<Tote> getTote() {
//        return tote;
//    }
//
//    public void setTote(Set<Tote> tote) {
//        this.tote = tote;
//    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public ELocationTag getLocationTag() {
        return locationTag;
    }

    public void setLocationTag(ELocationTag locationTag) {
        this.locationTag = locationTag;
    }
}
