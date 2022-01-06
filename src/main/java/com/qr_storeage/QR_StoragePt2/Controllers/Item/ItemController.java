package com.qr_storeage.QR_StoragePt2.Controllers.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemController repository;

//    @GetMapping
//    public ResponseEntity<Iterable<Item>> getAll(){
//        return new ResponseEntity<Iterable<Item>>(repository.findAll(), HttpStatus.OK);
//    }

//    @GetMapping("/createBarcode/{id}")
//    public String createBarcode(@PathVariable Long id){
//        try{
//            Item item = repository.findById(id); //TODO: Research why this repo does not have the same commands a s devRepo
//            Barcode_image.createBarCode128(item.getName()+ ".png");
//            Barcode_pdf.createBarCode128(item.getName()+ ".pdf");
//            return "Barcodes create for " + item.getName() + ".";
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @PostMapping
//    public Item createItem(@RequestBody Item item){
//        System.out.println(item.getLocation().getId());
//
//        return new ResponseEntity<Iterable<Item>>(repository.save(item), HttpStatus.OK);
//
//    }

}
