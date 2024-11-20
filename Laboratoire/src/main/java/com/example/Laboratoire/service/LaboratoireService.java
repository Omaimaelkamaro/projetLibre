package com.example.Laboratoire.service;

import com.example.Laboratoire.entity.Laboratoire;
import com.example.Laboratoire.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoireService {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    public Laboratoire createLaboratoire(Laboratoire laboratoire) {
        return laboratoireRepository.save(laboratoire);
    }

    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

    public Optional<Laboratoire> getLaboratoireById(Long id) {
        return laboratoireRepository.findById(id);
    }

    public Laboratoire updateLaboratoire(Long id, Laboratoire laboratoire) {
        if (laboratoireRepository.existsById(id)) {
            laboratoire.setId(id);
            return laboratoireRepository.save(laboratoire);
        }
        return null;
    }

    public boolean deleteLaboratoire(Long id) {
        if (laboratoireRepository.existsById(id)) {
            laboratoireRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
