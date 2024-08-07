package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @GetMapping("/muffins") //GET ALL MUFFINS
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/muffin/{id}") //GET SPECIFIC MUFFIN BY ID
    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/muffins") //CREATE NEW MUFFIN
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping("/muffin/{id}") //UPDATE SPECIFIC MUFFIN BY ID
    public ResponseEntity<Muffin> update(Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping("/muffin/{id}") //DELETE SPECIFIC MUFFIN BY ID
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
