package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Laboratoire;
import com.example.service.LaboratoireService;

import java.util.List;

@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {

    @Autowired
    private LaboratoireService laboratoireService;

    @GetMapping
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireService.getAllLaboratoires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable int id) {
        return laboratoireService.getLaboratoireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Laboratoire createLaboratoire(@RequestBody Laboratoire laboratoire) {
        return laboratoireService.createLaboratoire(laboratoire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire(@PathVariable int id, @RequestBody Laboratoire laboratoireDetails) {
        Laboratoire updatedLaboratoire = laboratoireService.updateLaboratoire(id, laboratoireDetails);
        return updatedLaboratoire != null ? ResponseEntity.ok(updatedLaboratoire) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratoire(@PathVariable int id) {
        if (laboratoireService.deleteLaboratoire(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Laboratoire> searchLaboratoires(@RequestParam String nom, @RequestParam boolean active) {
        return laboratoireService.searchLaboratoires(nom, active);
    }
}
