package com.example.examen.controller;



import com.example.examen.entity.Exam;
import com.example.examen.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<Exam> saveExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.saveExam(exam));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        return ResponseEntity.ok(examService.updateExam(id, updatedExam));
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<Exam> validateExam(@PathVariable Long id, @RequestParam Long validatedBy) {
        return ResponseEntity.ok(examService.validateExam(id, validatedBy));
    }



    @GetMapping("/dossier/{dossierId}")
    public ResponseEntity<List<Exam>> getExamsByDossier(@PathVariable Long dossierId) {
        return ResponseEntity.ok(examService.getExamsByDossier(dossierId));
    }

    @GetMapping("/{id}/report")
    public ResponseEntity<?> generateExamReport(@PathVariable Long id) {
        try {
            // Appelle le service pour générer un rapport
            String report = examService.generateReport(id);
            return ResponseEntity.ok(report);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Examen avec l'ID " + id + " introuvable.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la génération du rapport : " + e.getMessage());
        }
    }
}
