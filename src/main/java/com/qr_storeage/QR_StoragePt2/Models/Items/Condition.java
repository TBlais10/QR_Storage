package com.qr_storeage.QR_StoragePt2.Models.Items;

import com.qr_storeage.QR_StoragePt2.Models.Auth.ERole;

import javax.persistence.*;

@Entity
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECond name;

    public Condition() {
    }

    public Condition(Long id, ECond name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ECond getName() {
        return name;
    }

    public void setName(ECond name) {
        this.name = name;
    }
}
