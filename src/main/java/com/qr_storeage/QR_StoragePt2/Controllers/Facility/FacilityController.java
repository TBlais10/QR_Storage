package com.qr_storeage.QR_StoragePt2.Controllers.Facility;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Models.Facilities.Facility;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityRepository repository;

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping("/{id}")
    public Facility getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Facility> getAll(){
        return repository.findAll();
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
    public Facility createOne(@Valid @RequestBody Facility newFacility){
        return repository.save(newFacility);
    }

    @PostMapping("/photo")
    public Facility addPhoto(@RequestBody Facility facil){
        Facility facility = repository.findById(facil.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Avatar avatar = avatarRepository.save(facility.getAvatar());
        facility.setAvatar(avatar);
        return repository.save(facility);
    }

    @PutMapping("/{id}")
    public @ResponseBody Facility updateFacility(@PathVariable Long id, @RequestBody Facility updates){

        Facility facility = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (facility.getName() != null){
            facility.setName(updates.getName());
        }
        if (facility.getAvatar() != null){
            facility.setAvatar(updates.getAvatar());
        }

        return repository.save(facility);
    }

    @PostMapping("/addLocation")
    public @ResponseBody Facility addLocation(@RequestBody Facility updates){
        Facility facility = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        facility.getLocations().addAll(updates.getLocations());

        return repository.save(facility);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByFacilityId (@PathVariable Long id){
        String facilityName = repository.getById(id).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted the " + facilityName + " facility.", HttpStatus.OK);
    }


}
