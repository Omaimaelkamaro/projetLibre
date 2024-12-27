package com.example.Dossier.service;




import com.example.Dossier.entity.Patient;
import com.example.Dossier.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient non trouvé"));
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setNomComplet(updatedPatient.getNomComplet());
            existingPatient.setDateNaissance(updatedPatient.getDateNaissance());
            existingPatient.setAdresse(updatedPatient.getAdresse());
            // Ajoutez les autres champs à mettre à jour
            return patientRepository.save(existingPatient);
        }).orElseThrow(() -> new RuntimeException("Patient non trouvé"));
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

