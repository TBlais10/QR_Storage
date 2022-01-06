package com.qr_storeage.QR_StoragePt2.Controllers.Tote;

import com.qr_storeage.QR_StoragePt2.Repositories.ToteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/totes")
public class ToteController {

    @Autowired
    ToteRepository repository;

//    public String createBarcode(@PathVariable Long id){
//        try{
//            Tote tote = repository.findById(id); //TODO: Research why this repo does not have the same commands a s devRepo
//            Barcode_image.createBarCode128(tote.getName()+ ".png");
//            Barcode_pdf.createBarCode128(tote.getName()+ ".pdf");
//            return "Barcodes create for " + tote.getName() + ".";
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
