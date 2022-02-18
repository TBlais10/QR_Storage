package com.qr_storeage.QR_StoragePt2.Repositories;

import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    boolean findItemInLocationBy_Id(Long lId, Long iId);

}
