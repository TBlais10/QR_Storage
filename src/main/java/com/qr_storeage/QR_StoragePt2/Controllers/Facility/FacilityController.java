package com.qr_storeage.QR_StoragePt2.Controllers.Facility;

import com.qr_storeage.QR_StoragePt2.Models.Barcodes.ConnectToDatabase.Barcode_image;
import com.qr_storeage.QR_StoragePt2.Models.Barcodes.ConnectToDatabase.Barcode_pdf;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Facility")
public class FacilityController {

    @Autowired
    FacilityRepository repository;


}
