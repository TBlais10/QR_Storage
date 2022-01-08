package com.qr_storeage.QR_StoragePt2.Models.Totes;

import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Tote {

    @Id
    @GeneratedValue
    private Long id;
    private List<Item> items;
    private String name;

    @OneToOne
    private User user;

    public Tote() {
    }

    public Tote(List<Item> items, User user) {
        this.items = items;
        this.user = user;
        this.name = "Tote " + id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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
