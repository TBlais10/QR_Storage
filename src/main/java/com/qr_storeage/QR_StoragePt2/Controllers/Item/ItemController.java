package com.qr_storeage.QR_StoragePt2.Controllers.Item;

import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Item> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Item getOneItem(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //TODO: pull list of items from a specific location
//    @GetMapping("/{location}")
//    public ResponseEntity<Iterable<Item>> getAllInLocation(@PathVariable Long id){
//        try{
//            return locationRepository.findByLocationId(id).}
//    }


    @PostMapping //TODO: Implement try catch for Not Empty checks + Test by creating items.
    public ResponseEntity<Item> createItem(@RequestBody Item item){
//        System.out.println(item.getLocation().getId()); //TODO: Create method that iterates thru the list to check this field.

        return new ResponseEntity<>(repository.save(item), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public @ResponseBody Item updateOne (@PathVariable Long id, @RequestBody Item update){
        Item item = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.getName() != null) item.setName(update.getName());
        if (update.getDescription() != null) item.setDescription(update.getDescription());
        if (update.getQuantity() != null) item.setQuantity(update.getQuantity());
        if (update.getCond() != null) item.setCond(update.getCond());
        if (update.getStatus() != null) item.setStatus(update.getStatus());
        if (update.getType() != null) item.setType(update.getType());
        if (update.getColor() != null) item.setColor(update.getColor());
        if (update.getSerialNumber() != null) item.setSerialNumber(update.getSerialNumber());
        if (update.getPrice() != null) item.setPrice(update.getPrice());

        return repository.save(item);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByItemId(@PathVariable Long itemId){
        String itemName = repository.getById(itemId).getName();
        repository.deleteById(itemId);
        return new ResponseEntity<String>("Successfully Deleted " + itemName + ".", HttpStatus.OK);

    }

}
