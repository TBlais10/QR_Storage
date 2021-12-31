package com.qr_storeage.QR_StoragePt2.Controllers.Developer;

import com.qr_storeage.QR_StoragePt2.Models.Developers.Developer;
import com.qr_storeage.QR_StoragePt2.Repositories.AvatarRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.DeveloperRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public @ResponseBody Developer createDeveloper(@RequestBody Developer newDeveloper){
        return repository.save(newDeveloper);
    }

}
