package com.qr_storeage.QR_StoragePt2.Controllers.Client;

import com.qr_storeage.QR_StoragePt2.Models.Client.Client;
import com.qr_storeage.QR_StoragePt2.Repositories.ClientRepository;
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
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    ClientRepository repository;

    @GetMapping
    public List<Client> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Client getOne (@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Client> createClient (@Valid @RequestBody Client client){
        return new ResponseEntity<>(repository.save(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient (@PathVariable Long id){
        Client client = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.deleteById(id);

        if (client.getCompanyName() != null){
            return new ResponseEntity<>("Successfully deleted " + client.getCompanyName() + ".", HttpStatus.OK);
        }

        return new ResponseEntity<>("Successfully deleted " + client.getFirstName() + " " + client.getLastName() + ".", HttpStatus.OK);
    }

}
