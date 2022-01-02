package com.qr_storeage.QR_StoragePt2.Controllers.Item;

import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemController repository;

    @GetMapping
    public ResponseEntity<Iterable<Item>> getAll(){
        return new ResponseEntity<Iterable<Item>>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        System.out.println(item.getLocation().getId());

        return new ResponseEntity<Iterable<Item>>(repository.save(item), HttpStatus.OK);

    }
}
