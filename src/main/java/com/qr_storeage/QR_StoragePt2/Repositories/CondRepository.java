package com.qr_storeage.QR_StoragePt2.Repositories;

import com.qr_storeage.QR_StoragePt2.Models.Items.Cond;
import com.qr_storeage.QR_StoragePt2.Models.Items.ECond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CondRepository extends JpaRepository<Cond, Long> {
    Optional<Cond> findByName(ECond name);

    @Query(value = "select count(*) from cond",
            nativeQuery = true)
    int isCondEmpty();
}
