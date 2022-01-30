package com.qr_storeage.QR_StoragePt2.Models.Totes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Tote {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<Item> items;
    private String name;

    @OneToOne
    @JsonIgnoreProperties({"password"})
    private User user;


    public Tote() { //TODO: this.id returning null on tote creation.
        this.name = "TOTE-" + this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
