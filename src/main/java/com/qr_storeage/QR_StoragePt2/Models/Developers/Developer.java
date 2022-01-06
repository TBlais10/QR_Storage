package com.qr_storeage.QR_StoragePt2.Models.Developers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Developer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name must be filled in")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Email must be filled in")
    @Size(max = 50)
    private String email;
    private String facility;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    public Developer() {
    }

    public Developer(String name, String email, String facility) {
        this.name = name;
        this.email = email;
        this.facility = facility;
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

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    //for the class Facility
//    public Facility getFacility() {
//        return facility;
//    }
//
//    public void setFacility(Facility facility) {
//        this.facility = facility;
//    }
}
