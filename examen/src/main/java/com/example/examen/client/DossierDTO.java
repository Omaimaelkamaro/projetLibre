package com.example.examen.client;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class DossierDTO {
    private Long numDossier;


    private String fkEmailUtilisateur; // Email de l'utilisateur (référence externe)


    private Long fkIdPatient; // ID du patient (référence externe)

    // Précise le type de date (DATE, TIME ou TIMESTAMP)
    private Date date;


    private Boolean archivé = false;



    // Constructeurs
    public DossierDTO() {}

    public DossierDTO(String fkEmailUtilisateur, Long fkIdPatient, Date date) {
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




}


