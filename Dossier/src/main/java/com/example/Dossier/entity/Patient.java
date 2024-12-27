package com.example.Dossier.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomComplet;
    private String dateNaissance;
    private String lieuDeNaissance;
    private String sexe;
    private String typePieceIdentite;
    private String numPieceIdentite;
    private String adresse;
    private String numTel;
    private String email;

    // Constructeurs
    public Patient() {}

    public Patient(String nomComplet, String dateNaissance, String lieuDeNaissance, String sexe,
                   String typePieceIdentite, String numPieceIdentite, String adresse,
                   String numTel, String email) {
        this.nomComplet = nomComplet;
        this.dateNaissance = dateNaissance;
        this.lieuDeNaissance = lieuDeNaissance;
        this.sexe = sexe;
        this.typePieceIdentite = typePieceIdentite;
        this.numPieceIdentite = numPieceIdentite;
        this.adresse = adresse;
        this.numTel = numTel;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTypePieceIdentite() {
        return typePieceIdentite;
    }

    public void setTypePieceIdentite(String typePieceIdentite) {
        this.typePieceIdentite = typePieceIdentite;
    }

    public String getNumPieceIdentite() {
        return numPieceIdentite;
    }

    public void setNumPieceIdentite(String numPieceIdentite) {
        this.numPieceIdentite = numPieceIdentite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


