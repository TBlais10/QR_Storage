package com.qr_storeage.QR_StoragePt2.Models.History;
//purpose: To track what developer does to an item.
// TODO: 2/26/2022 After authentication implement this class.

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIncludeProperties({"id, name, location, quantity"})
    private Item item;

    @ManyToOne
    @JsonIncludeProperties({"id, name"})
    private Developer developer;

    @JsonFormat(pattern = "MM-DD-YYYY")
    private LocalDate logTime;

    public History() {
    }

    public History(Item item, Developer developer, LocalDate logTime) {
        this.item = item;
        this.developer = developer;
        this.logTime = logTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public LocalDate getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDate logTime) {
        this.logTime = logTime;
    }
}
