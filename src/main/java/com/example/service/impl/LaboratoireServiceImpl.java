package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Laboratoire;
import com.example.repository.LaboratoireRepository;
import com.example.service.LaboratoireService;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoireServiceImpl implements LaboratoireService {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    @Override
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

    @Override
    public Optional<Laboratoire> getLaboratoireById(int id) {
        return laboratoireRepository.findById(id);
    }

    @Override
    public Laboratoire createLaboratoire(Laboratoire laboratoire) {
        return laboratoireRepository.save(laboratoire);
    }

    @Override
    public Laboratoire updateLaboratoire(int id, Laboratoire updatedLaboratoire) {
        return laboratoireRepository.findById(id)
            .map(laboratoire -> {
                laboratoire.setNom(updatedLaboratoire.getNom());
                laboratoire.setLogo(updatedLaboratoire.getLogo());
                laboratoire.setRnc(updatedLaboratoire.getRnc());
                laboratoire.setActive(updatedLaboratoire.isActive());
                laboratoire.setDateActivation(updatedLaboratoire.getDateActivation());
                return laboratoireRepository.save(laboratoire);
            })
            .orElse(null);
    }

    @Override
    public boolean deleteLaboratoire(int id) {
        if (laboratoireRepository.existsById(id)) {
            laboratoireRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Laboratoire> searchLaboratoires(String nom, boolean active) {
        return laboratoireRepository.searchByNomOrStatus(nom, active);
    }
}
