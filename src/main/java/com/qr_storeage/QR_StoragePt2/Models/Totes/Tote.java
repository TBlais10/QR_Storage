package com.qr_storeage.QR_StoragePt2.Models.Totes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.qr_storeage.QR_StoragePt2.Models.Auth.User;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tote {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JsonIncludeProperties({"name", "quantity"})
    private Set<Item> items;
    private String name;

    @OneToOne
    @JsonIgnoreProperties({"password"})
    private User user;

    @OneToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;


    public Tote() {
    }

    public Tote(String name, Developer developer) {
        this.name = name;
        this.developer = developer;
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
