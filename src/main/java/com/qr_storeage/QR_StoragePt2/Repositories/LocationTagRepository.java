package com.qr_storeage.QR_StoragePt2.Repositories;

import com.qr_storeage.QR_StoragePt2.Models.Items.ELocationTag;
import com.qr_storeage.QR_StoragePt2.Models.Items.LocationTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationTagRepository extends JpaRepository<LocationTag, Long> {
    Optional<LocationTag> findByName(ELocationTag name);

    @Query(value = "select count(*) from location_tag",
            nativeQuery = true)
    int isTagEmpty();
}
