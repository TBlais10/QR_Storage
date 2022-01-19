package com.qr_storeage.QR_StoragePt2.Controllers.Developer;

import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.DeveloperRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/developers")

public class DevController {

    @Autowired
    private DeveloperRepository repository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping
    public @ResponseBody List<Developer> getDevelopers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Developer getOneDeveloper(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/facility/{facility}")
//    public ResponseEntity<List<Developer>> getDeveloperByFacility(@PathVariable String facility){
//        return new ResponseEntity<>(repository.findByFacility(facility, Sort.by("name")), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@Valid @RequestBody Developer newDeveloper){ //TODO: Try catches for @NotNull fields
        return new ResponseEntity<>(repository.save(newDeveloper), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Developer updateDeveloper(@Valid @PathVariable Long id, @RequestBody Developer updates){ //TODO: Try catches for @NotNull fields

        Developer developer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) developer.setName(updates.getName());
        if (updates.getEmail() != null) developer.setEmail(updates.getEmail());

        return repository.save(developer);
    }

    @PutMapping("/addFacility")
    public Developer addFacility(@RequestBody Developer updates){
        Developer developer = repository.findById(updates.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        developer.getFacilities().addAll(updates.getFacilities());

        return repository.save(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyDeveloper(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted user " + id, HttpStatus.OK);
    }

}
