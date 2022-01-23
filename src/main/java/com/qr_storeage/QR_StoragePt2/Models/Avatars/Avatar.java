package com.qr_storeage.QR_StoragePt2.Models.Avatars;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    public Avatar() {
    }

    public Avatar(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
