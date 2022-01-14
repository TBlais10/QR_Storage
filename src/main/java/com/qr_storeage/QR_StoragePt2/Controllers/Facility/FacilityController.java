package com.qr_storeage.QR_StoragePt2.Controllers.Facility;

import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/Facility")
public class FacilityController {

    @Autowired
    private FacilityRepository repository;

    @GetMapping
    public List<Facility> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Facility getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Facility> getById(@PathVariable Long id){
//        Optional<Facility> facility = repository.findById(id);
//
//        if (facility.isEmpty()){
//            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public Facility createOne(@RequestBody Facility newFacility){
        return repository.save(newFacility);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByFacilityId (@PathVariable Long id){
        String facilityName = repository.getById(id).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted the " + facilityName + " facility.", HttpStatus.OK);
    }


}
