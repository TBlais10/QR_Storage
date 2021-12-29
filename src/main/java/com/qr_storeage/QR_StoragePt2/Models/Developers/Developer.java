package com.qr_storeage.QR_StoragePt2.Models.Developers;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;

import javax.persistence.*;

@Entity
public class Developer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private Facility facility;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    private User user;


    public Developer() {
    }

    public Developer(String name, String email, Facility facility, Avatar avatar, User user) {
        this.name = name;
        this.email = email;
        this.facility = facility;
        this.avatar = avatar;
        this.user = user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
