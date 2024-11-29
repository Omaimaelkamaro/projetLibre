package com.example.Analyse.service;

import com.example.Analyse.entity.Analyse;
import com.example.Analyse.repository.AnalyseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyseService {

    private final AnalyseRepository analyseRepository;

    public AnalyseService(AnalyseRepository analyseRepository) {
        this.analyseRepository = analyseRepository;
    }

    // Recherche par nom
    public List<Analyse> searchAnalysesByName(String nom) {
        return analyseRepository.findByNomContaining(nom);
    }

    // Recherche par description
    public List<Analyse> searchAnalysesByDescription(String description) {
        return analyseRepository.findByDescriptionContaining(description);
    }

    // Récupérer toutes les analyses triées par nom
    public List<Analyse> getAllAnalysesSorted() {
        return analyseRepository.findAllByOrderByNomAsc();
    }

    // Récupérer toutes les analyses
    public List<Analyse> getAllAnalyses() {
        return analyseRepository.findAll();
    }

    // Récupérer une analyse par ID
    public Optional<Analyse> getAnalyseById(int id) {
        return analyseRepository.findById(id);
    }


    // Ajouter une nouvelle analyse
    public Analyse createAnalyse(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    // Mise à jour d'une analyse existante
    public Analyse updateAnalyse(int id, Analyse updatedAnalyse) {
        return analyseRepository.findById(id).map(analyse -> {
            analyse.setNom(updatedAnalyse.getNom());
            analyse.setDescription(updatedAnalyse.getDescription());
            // analyse.setEpreuves(updatedAnalyse.getEpreuves());
            return analyseRepository.save(analyse);
        }).orElseThrow(() -> new RuntimeException("Analyse not found with id: " + id));
    }

    // Supprimer une analyse
    public void deleteAnalyse(int id) {
        if (analyseRepository.existsById(id)) {
            analyseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Analyse not found with id: " + id);
        }
    }
}
