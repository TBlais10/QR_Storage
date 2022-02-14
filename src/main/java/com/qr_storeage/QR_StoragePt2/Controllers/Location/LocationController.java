package com.qr_storeage.QR_StoragePt2.Controllers.Location;

import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Location> getAll (){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Location getOneLocation(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        return new ResponseEntity<>(repository.save(location), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public @ResponseBody Location updateLocation(@PathVariable Long id, @RequestBody Location updates){
        Location location = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (location.getName() != null) {
            location.setName(updates.getName());
        }
        if (location.site != null){
            location.site = updates.site;
        }

        return repository.save(location);
    }

    @PostMapping("/addItem/{iId}") //TODO: Create if null catch + infinite json body
    public @ResponseBody Location addItem(@RequestBody Location updates, @PathVariable Long iId){ //TODO: Create if null check
        Location location = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Item item = itemRepository.findById(iId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        location.items.add(item);

        return repository.save(location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById (@PathVariable Long id){
        String locationName = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted " + locationName + ".", HttpStatus.OK);
    }

}
