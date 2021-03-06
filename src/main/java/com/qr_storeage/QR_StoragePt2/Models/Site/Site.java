package com.qr_storeage.QR_StoragePt2.Models.Site;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Facility must have a name.")
    private String name;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"site", "items"})
    public Set<Location> locations;

    @ManyToMany
    @JoinTable(
            name="developer_facility",
            joinColumns = @JoinColumn(name = "site_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    @JsonIgnoreProperties({"email", "avatar", "sites"})
    public Set<Developer> developers;

    //@ManyToMany
//    private User users;

    public Site() {
    }

    public Site(String name, Avatar avatar) {
        this.name = name;
        this.avatar = avatar;
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


//    public User getUsers() {
//        return users;
//    }
//
//    public void setUsers(User users) {
//        this.users = users;
//    }
}
