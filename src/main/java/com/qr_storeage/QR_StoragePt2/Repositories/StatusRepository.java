package com.qr_storeage.QR_StoragePt2.Repositories;

import com.qr_storeage.QR_StoragePt2.Models.Auth.ERole;
import com.qr_storeage.QR_StoragePt2.Models.Auth.Role;
import com.qr_storeage.QR_StoragePt2.Models.Items.EStatus;
import com.qr_storeage.QR_StoragePt2.Models.Items.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByName(EStatus name);

    @Query(value = "select count(*) from status",
            nativeQuery = true)
    int isStatusEmpty();
}
