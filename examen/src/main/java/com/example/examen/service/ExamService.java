package com.example.examen.service;


import com.example.examen.entity.Exam;
import com.example.examen.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        Optional<Exam> existingExam = examRepository.findById(id);
        if (existingExam.isPresent()) {
            Exam exam = existingExam.get();
            exam.setResultat(updatedExam.getResultat());
            exam.setObservations(updatedExam.getObservations());
            exam.setCommentairesTechnicien(updatedExam.getCommentairesTechnicien());
            exam.setUpdatedAt(updatedExam.getUpdatedAt());
            return examRepository.save(exam);
        }
        throw new RuntimeException("Exam not found");
    }

    public Exam validateExam(Long id, Long validatedBy) {
        Exam exam = examRepository.findById(id).orElseThrow(() -> new RuntimeException("Exam not found"));
        exam.setValidated(true);
        exam.setValidatedBy(validatedBy);
        return examRepository.save(exam);
    }

    public List<Exam> getExamsByDossier(Long dossierId) {
        return examRepository.findByFkNumDossier(dossierId);
    }

    public String generateReport(Long id) {
        // Vérifie si l'examen existe
        Exam exam = examRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Examen non trouvé pour l'ID : " + id)
        );

        // Logique pour générer un rapport (simplifiée ici)
        return "Rapport pour l'examen ID : " + id + "\n" +
                "Dossier : " + exam.getFkNumDossier() + "\n" +
                "Épreuve : " + exam.getFkIdEpreuve() + "\n" +
                "Test Analyse : " + exam.getFkIdTestAnalyse() + "\n" +
                "Résultat : " + exam.getResultat();
    }
}

