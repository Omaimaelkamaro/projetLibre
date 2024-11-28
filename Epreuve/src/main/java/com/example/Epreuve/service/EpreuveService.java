package com.example.Epreuve.service;

import com.example.Epreuve.entity.Epreuve;
import com.example.Epreuve.Repository.EpreuveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;


@Service
public class EpreuveService {

    private final EpreuveRepository epreuveRepository;

    @Autowired
    public EpreuveService(EpreuveRepository epreuveRepository) {
        this.epreuveRepository = epreuveRepository;
    }

    // Ajouter une épreuve
    public Epreuve createEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    // Mettre à jour une épreuve
    public Optional<Epreuve> updateEpreuve(Long id, Epreuve epreuveDetails) {
        return epreuveRepository.findById(id).map(existingEpreuve -> {
            existingEpreuve.setFkIdAnalyse(epreuveDetails.getFkIdAnalyse());
            existingEpreuve.setNom(epreuveDetails.getNom());
            return epreuveRepository.save(existingEpreuve);
        });
    }

    // Supprimer une épreuve
    public void deleteEpreuve(Long id) {
        epreuveRepository.deleteById(id);
    }

    // Récupérer toutes les épreuves
    public List<Epreuve> getAllEpreuves() {
        return epreuveRepository.findAll();
    }

    // Récupérer une épreuve par ID
    public Optional<Epreuve> getEpreuveById(Long id) {
        return epreuveRepository.findById(id);
    }
}
