package com.qr_storeage.QR_StoragePt2.Controllers.Developer;

import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.DeveloperRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/developers")

public class DevController {

    @Autowired
    private DeveloperRepository repository;

    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<Developer> getDevelopers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Developer getOneDeveloper(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/facility/{facility}")
    public ResponseEntity<List<Developer>> getDeveloperByFacility(@PathVariable String facility){
        return new ResponseEntity<>(repository.findByFacility(facility, Sort.by("name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer newDeveloper){
        return new ResponseEntity<>(repository.save(newDeveloper), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Developer updateDeveloper(@PathVariable Long id, @RequestBody Developer updates){

        Developer developer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) developer.setName(updates.getName());
        if (updates.getEmail() != null) developer.setEmail(updates.getEmail());
        if (updates.getFacility() != null) developer.setFacility(updates.getFacility());

        return repository.save(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyDeveloper(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted user " + id, HttpStatus.OK);
    }

}
