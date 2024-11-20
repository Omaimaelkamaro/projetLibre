package com.example.Laboratoire.controller;

import com.example.Laboratoire.entity.Laboratoire;
import com.example.Laboratoire.service.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {

    @Autowired
    private LaboratoireService laboratoireService;

    // Créer un laboratoire
    @PostMapping
    public ResponseEntity<Laboratoire> createLaboratoire(@RequestBody Laboratoire laboratoire) {
        Laboratoire createdLaboratoire = laboratoireService.createLaboratoire(laboratoire);
        return new ResponseEntity<>(createdLaboratoire, HttpStatus.CREATED);
    }

    // Lister tous les laboratoires
    @GetMapping
    public ResponseEntity<List<Laboratoire>> getAllLaboratoires() {
        List<Laboratoire> laboratoires = laboratoireService.getAllLaboratoires();
        return new ResponseEntity<>(laboratoires, HttpStatus.OK);
    }

    // Récupérer un laboratoire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable Long id) {
        Optional<Laboratoire> laboratoire = laboratoireService.getLaboratoireById(id);
        return laboratoire.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Mettre à jour un laboratoire
    @PutMapping("/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire(@PathVariable Long id, @RequestBody Laboratoire laboratoire) {
        Laboratoire updatedLaboratoire = laboratoireService.updateLaboratoire(id, laboratoire);
        return updatedLaboratoire != null ? ResponseEntity.ok(updatedLaboratoire) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un laboratoire
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratoire(@PathVariable Long id) {
        return laboratoireService.deleteLaboratoire(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
