package com.qr_storeage.QR_StoragePt2.Models.Developers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qr_storeage.QR_StoragePt2.Models.Authentication.User;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Size(min = 5)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "developer_facility",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "facility_id")
    )
    private Set<Facility> facilities = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonIgnore
//    private User user;


    public Developer() {
    }

    public Developer(String name, String email, Avatar avatar/*, User user*/) {
        this.name = name;
        this.email = email;
        this.avatar = avatar;
//        this.user = user;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}