package com.example.Dossier.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dossiers")
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numDossier;

    public boolean isArchivé() {
        return archivé;
    }

    public void setArchivé(boolean archivé) {
        this.archivé = archivé;
    }

    private String fkEmailUtilisateur; // Email de l'utilisateur (référence externe)
    private Long fkIdPatient;          // ID du patient (référence externe)
    private Date date;

    @Column(name = "archivé")
    private boolean archivé = false;

    @ManyToOne
    private Patient patient;


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
}
