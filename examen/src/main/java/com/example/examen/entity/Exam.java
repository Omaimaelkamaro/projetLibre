package com.example.examen.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long fkNumDossier;

    @Column(nullable = false)
    private Long fkIdEpreuve;

    @Column(nullable = false)
    private Long fkIdTestAnalyse;

    @Column(nullable = false)
    private String resultat;

    private String observations;
    private String commentairesTechnicien;

    private Boolean validated = false;

    private Long validatedBy;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    // Constructeur sans argument
    public Exam() {
    }

    // Constructeur avec tous les champs sauf l'id
    public Exam(Long fkNumDossier, Long fkIdEpreuve, Long fkIdTestAnalyse, String resultat, String observations,
                String commentairesTechnicien, Boolean validated, Long validatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.fkNumDossier = fkNumDossier;
        this.fkIdEpreuve = fkIdEpreuve;
        this.fkIdTestAnalyse = fkIdTestAnalyse;
        this.resultat = resultat;
        this.observations = observations;
        this.commentairesTechnicien = commentairesTechnicien;
        this.validated = validated;
        this.validatedBy = validatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkNumDossier() {
        return fkNumDossier;
    }

    public void setFkNumDossier(Long fkNumDossier) {
        this.fkNumDossier = fkNumDossier;
    }

    public Long getFkIdEpreuve() {
        return fkIdEpreuve;
    }

    public void setFkIdEpreuve(Long fkIdEpreuve) {
        this.fkIdEpreuve = fkIdEpreuve;
    }

    public Long getFkIdTestAnalyse() {
        return fkIdTestAnalyse;
    }

    public void setFkIdTestAnalyse(Long fkIdTestAnalyse) {
        this.fkIdTestAnalyse = fkIdTestAnalyse;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getCommentairesTechnicien() {
        return commentairesTechnicien;
    }

    public void setCommentairesTechnicien(String commentairesTechnicien) {
        this.commentairesTechnicien = commentairesTechnicien;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Long getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(Long validatedBy) {
        this.validatedBy = validatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Méthode toString pour un affichage simple de l'entité
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", fkNumDossier=" + fkNumDossier +
                ", fkIdEpreuve=" + fkIdEpreuve +
                ", fkIdTestAnalyse=" + fkIdTestAnalyse +
                ", resultat='" + resultat + '\'' +
                ", observations='" + observations + '\'' +
                ", commentairesTechnicien='" + commentairesTechnicien + '\'' +
                ", validated=" + validated +
                ", validatedBy=" + validatedBy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
