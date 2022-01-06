package com.qr_storeage.QR_StoragePt2.Models.Facilities;

import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

import javax.persistence.*;
import java.util.List;

@Entity
public class Facility {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private List<Location> locations;

    @OneToMany
    private Developer developers;

    @OneToMany
    private User users;

    public Facility() {
    }

    public Facility(String name, Avatar avatar, List<Location> locations) {
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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Developer getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developer developers) {
        this.developers = developers;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
