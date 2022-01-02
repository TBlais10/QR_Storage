package com.qr_storeage.QR_StoragePt2.Repositories;

import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
