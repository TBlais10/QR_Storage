package com.qr_storeage.QR_StoragePt2.Controllers.Location;

import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationRepository repository;

    @Autowired
    ItemRepository itemRepository;

//    @GetMapping
//    public String createBarcode(@PathVariable Long id){
//        try{
//            Location location = repository.findById(id); //TODO: Research why this repo does not have the same commands a s devRepo
//            Barcode_image.createBarCode128(location.getName()+ ".png");
//            Barcode_pdf.createBarCode128(location.getName()+ ".pdf");
//            return "Barcodes create for " + location.getName() + ".";
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
