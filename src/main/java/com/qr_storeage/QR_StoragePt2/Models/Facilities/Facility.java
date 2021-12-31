package com.qr_storeage.QR_StoragePt2.Models.Facilities;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

import javax.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;
    private Location[] locations;

    public Facility() {
    }

    public Facility(String name, Avatar avatar, Location[] locations) {
        this.name = name;
        this.avatar = avatar;
        this.locations = locations;
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }
}
