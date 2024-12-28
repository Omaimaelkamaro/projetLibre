package com.example.examen.controller;



import com.example.examen.client.DossierDTO;
import com.example.examen.client.EpreuveDTO;
import com.example.examen.entity.Exam;
import com.example.examen.service.ExamService;
import com.example.examen.serviceClient.DossierService;
import com.example.examen.serviceClient.EpreuveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;
    private final EpreuveService epreuveService;

    private final DossierService dossierService;


    public ExamController(ExamService examService,EpreuveService epreuveService,DossierService dossierService) {

        this.examService = examService;
        this.epreuveService = epreuveService;
        this.dossierService = dossierService;
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

    @GetMapping("/epreuves/{id}")
    public EpreuveDTO getEpreuveById(@PathVariable Long id) {
        return epreuveService.getEpreuveDetails(id);
    }

    @GetMapping("/dossiers/{id}")
    public DossierDTO getDossierByNumDossier(@PathVariable Long id) {
        return dossierService.getDossierDetails(id);
    }
}