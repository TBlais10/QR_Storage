package com.qr_storeage.QR_StoragePt2.Models.Totes;

import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Models.Items.SalesItem;

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
    private List<SalesItem> salesItems;

    @OneToOne
    private User user;

    public Tote() {
    }

    public Tote(List<Item> items, List<SalesItem> salesItems, User user) {
        this.items = items;
        this.salesItems = salesItems;
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

    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
