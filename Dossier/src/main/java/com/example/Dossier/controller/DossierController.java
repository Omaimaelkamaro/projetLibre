package com.example.Dossier.controller;


import com.example.Dossier.entity.Dossier;
import com.example.Dossier.repository.DossierRepository;
import com.example.Dossier.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dossiers")
public class DossierController {

    @Autowired
    private DossierService dossierService;
    @Autowired
    private DossierRepository dossierRepository;


    @GetMapping
    public List<Dossier> getAllDossiers() {
        return dossierService.getAllDossiers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getDossierById(@PathVariable Long id) {
        return dossierService.getDossierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{email}")
    public List<Dossier> getDossiersByUser(@PathVariable String email) {
        return dossierService.getDossiersByUser(email);
    }

    @PostMapping
    public Dossier createDossier(@RequestBody Dossier dossier) {
        return dossierService.createDossier(dossier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dossier> updateDossier(@PathVariable Long id, @RequestBody Dossier dossier) {
        return ResponseEntity.ok(dossierService.updateDossier(id, dossier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> archiveOrDeleteDossier(@PathVariable Long id) {
        dossierService.archiveOrDeleteDossier(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/archiver")
    public ResponseEntity<Dossier> archiverDossier(@PathVariable Long id) {
        Optional<Dossier> dossierOptional = dossierRepository.findById(id);

        if (dossierOptional.isPresent()) {
            Dossier dossier = dossierOptional.get();
            dossier.setArchivé(true);  // On marque le dossier comme archivé
            dossierRepository.save(dossier);  // Sauvegarde dans la base de données

            return ResponseEntity.ok(dossier);  // Retourne le dossier archivé
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/archivés")
    public List<Dossier> getDossiersArchivés() {
        return dossierRepository.findByArchivé(true);
    }

}
