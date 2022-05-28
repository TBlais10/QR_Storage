package com.qr_storeage.QR_StoragePt2.Models.Developers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr_storeage.QR_StoragePt2.Models.Auth.User;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Site.Site;
import com.qr_storeage.QR_StoragePt2.Models.Totes.Tote;

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

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 20)
    private String fName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 30)
    private String lName;

    @NotBlank(message = "Please provide your age")
    @Size(max = 3)
    private long age;

    @NotBlank(message = "Please provide your gender")
    private String gender;

    @NotBlank(message = "Email cannot be blank")
    @Size(min = 5)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "developer_facility",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "site_id")
    )
    @JsonIgnoreProperties("locations")
    public Set<Site> sites = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToOne
    @JoinColumn(name = "tote_id")
    private Tote tote;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    public Developer() {
    }

    public Developer(String fName, String lName, long age, String gender, String email, Avatar avatar, Tote tote, User user) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.avatar = avatar;
        this.tote = tote;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Set<Site> getSites() {
        return sites;
    }

    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }

    public Tote getTote() {
        return tote;
    }

    public void setTote(Tote tote) {
        this.tote = tote;
    }
}