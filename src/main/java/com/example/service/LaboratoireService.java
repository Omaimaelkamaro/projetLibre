package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entities.Laboratoire;

public interface LaboratoireService {
    List<Laboratoire> getAllLaboratoires();
    Optional<Laboratoire> getLaboratoireById(int id);
    Laboratoire createLaboratoire(Laboratoire laboratoire);
    Laboratoire updateLaboratoire(int id, Laboratoire updatedLaboratoire);
    boolean deleteLaboratoire(int id);
    List<Laboratoire> searchLaboratoires(String nom, boolean active);
}
