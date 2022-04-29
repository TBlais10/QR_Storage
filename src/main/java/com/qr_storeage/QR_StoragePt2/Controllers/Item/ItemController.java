package com.qr_storeage.QR_StoragePt2.Controllers.Item;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Items.ELocationTag;
import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping
    public List<Item> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Item getOneItem(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    // TODO: 2/17/2022 test!
//    @GetMapping("/{Iid}")
//    public Set<Location> findItemLocations (@PathVariable Long id){
//        Item item = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        return item.location;
//    }

    @PostMapping //TODO: Implement try catch for Not Empty checks + Test by creating items.
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item){
//        System.out.println(item.getLocation().getId()); //TODO: Create method that iterates thru the list to check this field.

        // TODO: 2/17/2022 TEST!
        if (repository.findItemByName(item.getName())){
            return null;
        }

        return new ResponseEntity<>(repository.save(item), HttpStatus.OK);

    }

    @PostMapping("/photo")
    public Item addPhoto(@RequestBody Item itm){
        Item item = repository.findById(itm.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (item.getAvatar() != null){
            Avatar avatar = item.getAvatar();
            avatar.setUrl(itm.getAvatar().getUrl());
            avatarRepository.save(avatar);
            return item;
        }
        Avatar avatar = avatarRepository.save(itm.getAvatar());
        item.setAvatar(avatar);
        return repository.save(item);

    }

    @PutMapping("/update/{id}")
    public @ResponseBody Item updateOne (@PathVariable Long id, @RequestBody Item update){
        Item item = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.getName() != null) item.setName(update.getName());
        if (update.getDescription() != null) item.setDescription(update.getDescription());
        if (update.getTags() != null) item.setTags(update.getTags());
        if (update.getQuantity() != null) item.setQuantity(update.getQuantity());
        if (update.getCond() != null) item.setCond(update.getCond());
        if (update.getStatus() != null) item.setStatus(update.getStatus());
        if (update.getType() != null) item.setType(update.getType());
        if (update.getColor() != null) item.setColor(update.getColor());
        if (update.getSerialNumber() != null) item.setSerialNumber(update.getSerialNumber());
        if (update.getPrice() != null) item.setPrice(update.getPrice());

        return repository.save(item);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuantity(@PathVariable Long id,@RequestBody Item update){
        Item item = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.getQuantity() != null) item.setQuantity(update.getQuantity());

        // TODO: 2/26/2022 if quantity is going to go negative, create a catch and confirm.

        if (update.getQuantity() == 0 && update.getLocationTag() != ELocationTag.PRIMARY){
            repository.deleteById(id);
        }

        repository.save(update);
        return new ResponseEntity<String>("Updated Quantity of " + update.getName() + " to " + update.getQuantity(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByItemId(@PathVariable Long itemId){
        String itemName = repository.getById(itemId).getName();
        repository.deleteById(itemId);
        return new ResponseEntity<String>("Successfully Deleted " + itemName + ".", HttpStatus.OK);

    }

}
