package com.example.Dossier.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dossiers")
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numDossier;


    private String fkEmailUtilisateur; // Email de l'utilisateur (référence externe)


    private Long fkIdPatient; // ID du patient (référence externe)

     // Précise le type de date (DATE, TIME ou TIMESTAMP)
    private Date date;


    private Boolean archivé = false;

    @ManyToOne()
    @JoinColumn()
    private Patient patient;

    // Constructeurs
    public Dossier() {}

    public Dossier(String fkEmailUtilisateur, Long fkIdPatient, Date date) {
        this.fkEmailUtilisateur = fkEmailUtilisateur;
        this.fkIdPatient = fkIdPatient;
        this.date = date;
    }

    // Getters et Setters
    public Long getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(Long numDossier) {
        this.numDossier = numDossier;
    }

    public String getFkEmailUtilisateur() {
        return fkEmailUtilisateur;
    }

    public void setFkEmailUtilisateur(String fkEmailUtilisateur) {
        this.fkEmailUtilisateur = fkEmailUtilisateur;
    }

    public Long getFkIdPatient() {
        return fkIdPatient;
    }

    public void setFkIdPatient(Long fkIdPatient) {
        this.fkIdPatient = fkIdPatient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getArchivé() {
        return archivé;
    }

    public void setArchivé(Boolean archivé) {
        this.archivé = archivé;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
