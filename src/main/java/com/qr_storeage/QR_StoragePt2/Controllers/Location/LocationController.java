package com.qr_storeage.QR_StoragePt2.Controllers.Location;

import com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode_image;
import com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode_pdf;
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
@RequestMapping("/api/location")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById (@PathVariable Long id){
        String locationName = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted " + locationName + ".", HttpStatus.OK);
    }

}
