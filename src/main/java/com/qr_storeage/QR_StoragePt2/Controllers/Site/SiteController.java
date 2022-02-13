package com.qr_storeage.QR_StoragePt2.Controllers.Site;

import com.qr_storeage.QR_StoragePt2.Models.Avatars.Avatar;
import com.qr_storeage.QR_StoragePt2.Models.Site.Site;
import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.SiteRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/sites")
public class SiteController {

    @Autowired
    private SiteRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping("/{id}")
    public Site getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Site> getAll(){
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
    public Site createOne(@Valid @RequestBody Site newSite){
        return repository.save(newSite);
    }

    @PostMapping("/photo")
    public Site addPhoto(@RequestBody Site facil){
        Site site = repository.findById(facil.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (site.getAvatar() != null){
            Avatar avatar = site.getAvatar();
            avatar.setUrl(facil.getAvatar().getUrl());
            avatarRepository.save(avatar);
            return site;
        }

        Avatar avatar = avatarRepository.save(facil.getAvatar());
        site.setAvatar(avatar);
        return repository.save(site);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Site updateSite(@PathVariable Long id, @RequestBody Site updates){

        Site site = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (site.getName() != null){
            site.setName(updates.getName());
        }
        if (site.getAvatar() != null){
            site.setAvatar(updates.getAvatar());
        }

        return repository.save(site);
    }

    @PostMapping("/addLocation/{lId}") //TODO: Create if null catch + infinite json body
    public @ResponseBody
    Site addLocation(@RequestBody Site updates, @PathVariable Long lId){
        Site site = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Location location = locationRepository.findById(lId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        site.locations.add(location);

        return repository.save(site);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBySiteId (@PathVariable Long id){
        String facilityName = repository.getById(id).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted the " + facilityName + " Site.", HttpStatus.OK);
    }


}
