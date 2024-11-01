package com.example.controller;

import com.example.dto.AdresseDto;
import com.example.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @PostMapping
    public ResponseEntity<AdresseDto> addAdresse(@RequestBody AdresseDto adresseDTO) {
    	AdresseDto createdAdresse = adresseService.addAdresse(adresseDTO);
        return ResponseEntity.ok(createdAdresse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdresseDto> updateAdresse(@PathVariable int id, @RequestBody AdresseDto adresseDTO) {
    	AdresseDto updatedAdresse = adresseService.updateAdresse(id, adresseDTO);
        return ResponseEntity.ok(updatedAdresse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdresseDto> getAdresseById(@PathVariable int id) {
    	AdresseDto adresseDTO = adresseService.getAdresseById(id);
        return ResponseEntity.ok(adresseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AdresseDto>> getAllAdresses() {
        List<AdresseDto> adresses = adresseService.getAllAdresses();
        return ResponseEntity.ok(adresses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable int id) {
        adresseService.deleteAdresse(id);
        return ResponseEntity.noContent().build();
    }
}
