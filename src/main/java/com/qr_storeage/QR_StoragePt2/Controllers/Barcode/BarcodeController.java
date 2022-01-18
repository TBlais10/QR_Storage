package com.qr_storeage.QR_StoragePt2.Controllers.Barcode;

import com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode128.Barcode128;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import com.qr_storeage.QR_StoragePt2.Models.Totes.Tote;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.ToteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api/barcodes")
public class BarcodeController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ToteRepository toteRepository;

    @GetMapping("/item/{id}")
    public String createItemBarcode(@PathVariable Long id){
        try{
            Item item = itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            Barcode128.createBarCode128(item.getName()+ ".png");
            return "Barcodes create for " + item.getName() + ".";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/location/{id}")
    public String createLocationBarcode(@PathVariable Long id){
        try{
            Location location = locationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            Barcode128.createBarCode128(location.getName()+ ".png");
            return "Barcodes create for " + location.getName() + ".";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/tote/{id}")
    public String createToteBarcode(@PathVariable Long id){
        try{
            Tote tote = toteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            Barcode128.createBarCode128(tote.getName()+ ".png");
            return "Barcodes create for " + tote.getName() + ".";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
