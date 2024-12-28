package com.example.Analyse.controller;


import com.example.Analyse.client.LaboratoireDTO;
import com.example.Analyse.entity.Analyse;
import com.example.Analyse.service.AnalyseService;

import com.example.Analyse.serviceClient.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseController {
   @Autowired
    private final AnalyseService analyseService;

    public AnalyseController(AnalyseService analyseService ,LaboratoireService laboratoireService) {
        this.analyseService = analyseService;
        this.laboratoireService = laboratoireService;

    }

    @GetMapping
    public List<Analyse> getAllAnalyses() {
        return analyseService.getAllAnalyses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analyse> getAnalyseById(@PathVariable int id) {
        return analyseService.getAnalyseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Analyse createAnalyse(@RequestBody Analyse analyse) {
        return analyseService.createAnalyse(analyse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analyse> updateAnalyse(@PathVariable int id, @RequestBody Analyse analyse) {
        try {
            return ResponseEntity.ok(analyseService.updateAnalyse(id, analyse));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyse(@PathVariable int id) {
        try {
            analyseService.deleteAnalyse(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    private final LaboratoireService laboratoireService;


    @GetMapping("/laboratoires/{id}")
    public LaboratoireDTO getLaboratoireById(@PathVariable Long id) {
        return laboratoireService.getLaboratoireDetails(id);
    }
}

