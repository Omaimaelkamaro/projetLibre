package com.example.Epreuve.controller;

import com.example.Epreuve.client.AnalyseDto;
import com.example.Epreuve.entity.Epreuve;

import com.example.Epreuve.service.EpreuveService;
import com.example.Epreuve.serviceClient.AnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/epreuves")
public class EpreuveController {

    private final EpreuveService epreuveService;
    private final AnalyseService analyseService;

    @Autowired
    public EpreuveController(EpreuveService epreuveService, AnalyseService analyseService) {

        this.epreuveService = epreuveService;
        this.analyseService = analyseService;
    }

    // Créer une épreuve
    @PostMapping
    public ResponseEntity<Epreuve> createEpreuve(@RequestBody Epreuve epreuve) {
        Epreuve newEpreuve = epreuveService.createEpreuve(epreuve);
        return ResponseEntity.ok(newEpreuve);
    }

    // Mettre à jour une épreuve
    @PutMapping("/{id}")
    public ResponseEntity<Epreuve> updateEpreuve(@PathVariable Long id, @RequestBody Epreuve epreuveDetails) {
        return epreuveService.updateEpreuve(id, epreuveDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une épreuve
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpreuve(@PathVariable Long id) {
        epreuveService.deleteEpreuve(id);
        return ResponseEntity.noContent().build();
    }

    // Obtenir toutes les épreuves
    @GetMapping
    public ResponseEntity<List<Epreuve>> getAllEpreuves() {
        return ResponseEntity.ok(epreuveService.getAllEpreuves());
    }

    // Obtenir une épreuve par ID
    @GetMapping("/{id}")
    public ResponseEntity<Epreuve> getEpreuveById(@PathVariable Long id) {
        return epreuveService.getEpreuveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/analyses/{id}")
    public AnalyseDto getAnalyseById(@PathVariable Long id) {
        return analyseService.getAnalyseDetails(id);
    }
}

