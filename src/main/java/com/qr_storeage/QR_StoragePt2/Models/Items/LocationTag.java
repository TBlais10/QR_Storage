package com.qr_storeage.QR_StoragePt2.Models.Items;

import javax.persistence.*;

@Entity
public class LocationTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ELocationTag name;

    public LocationTag() {
    }

    public LocationTag(Long id, ELocationTag name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ELocationTag getName() {
        return name;
    }

    public void setName(ELocationTag name) {
        this.name = name;
    }
}
