package com.example.Dossier.service;


import com.example.Dossier.entity.Dossier;
import com.example.Dossier.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }

    public Optional<Dossier> getDossierById(Long id) {
        return dossierRepository.findById(id);
    }

    public List<Dossier> getDossiersByUser(String emailUtilisateur) {
        return dossierRepository.findByFkEmailUtilisateur(emailUtilisateur);
    }

    public Dossier createDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    public Dossier updateDossier(Long id, Dossier updatedDossier) {
        return dossierRepository.findById(id)
                .map(existingDossier -> {
                    existingDossier.setFkEmailUtilisateur(updatedDossier.getFkEmailUtilisateur());
                    existingDossier.setFkIdPatient(updatedDossier.getFkIdPatient());
                    existingDossier.setDate(updatedDossier.getDate());
                    return dossierRepository.save(existingDossier);
                })
                .orElseThrow(() -> new RuntimeException("Dossier non trouvé"));
    }

    public void archiveOrDeleteDossier(Long id) {
        dossierRepository.deleteById(id);
    }

    public List<Dossier> getDossiersArchivé(boolean archivé) {
        return dossierRepository.findByArchivé(archivé);
    }
}
