package com.qr_storeage.QR_StoragePt2.Controllers.Tote;

import com.qr_storeage.QR_StoragePt2.Models.Items.Item;
import com.qr_storeage.QR_StoragePt2.Models.Totes.Tote;
import com.qr_storeage.QR_StoragePt2.Repositories.ToteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/totes")
public class ToteController {

    @Autowired
    private ToteRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Tote>> getAll (){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Tote findById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id")
    public Set<Item> itemsInTote (@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getItems();
    }

    @PostMapping
    public ResponseEntity<Tote> createTote(@RequestBody Tote tote){
        return new ResponseEntity<>(repository.save(tote), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById (@PathVariable Long id){
        String toteName = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getName();
        repository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted " + toteName + " .", HttpStatus.OK);
    }

}
