package com.qr_storeage.QR_StoragePt2.Controllers.Facility;

import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/Facility")
public class FacilityController {

    @Autowired
    FacilityRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Facility>> getAll(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Facility getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    @PostMapping
//    public ResponseEntity<Facility> createOne(@RequestBody Facility facility){
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByFacilityId (@PathVariable Long id){
        String facilityName = repository.getById(id).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted the " + facilityName + " facility.", HttpStatus.OK);
    }


}
