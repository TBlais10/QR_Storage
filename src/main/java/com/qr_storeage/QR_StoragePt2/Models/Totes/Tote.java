package com.qr_storeage.QR_StoragePt2.Models.Totes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tote {

    @Id
    @GeneratedValue
    private Long id;
    private List<Item> items;
    private User user;

    public Tote() {
    }

    public Tote(List<Item> items, User user) {
        this.items = items;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
