package com.qr_storeage.QR_StoragePt2.Controllers.Item;

import com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode_image;
import com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode_pdf;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Item>> getAll(){
        return new ResponseEntity<Iterable<Item>>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/createBarcode/{id}")
    public String createBarcode(@PathVariable Long id){
        try{
            Item item = repository.findById(id).orElseThrow(() => );
            Barcode_image.createBarCode128(item.getName()+ ".png");
            Barcode_pdf.createBarCode128(item.getName()+ ".pdf");
            return "Barcodes create for " + item.getName() + ".";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        System.out.println(item.getLocation().getId());

        return new ResponseEntity<>(repository.save(item), HttpStatus.OK);

    }

}
