package com.qr_storeage.QR_StoragePt2.Models.Facilities;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
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
    private List<Location> locations;

    public Avatar getAvatar() {
        return avatar;
    }


}
