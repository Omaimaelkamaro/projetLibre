package com.example.Epreuve.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fkIdAnalyse;

    private String nom;

    // Constructeurs
    public Epreuve() {
    }

    public Epreuve(Long fkIdAnalyse, String nom) {
        this.fkIdAnalyse = fkIdAnalyse;
        this.nom = nom;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkIdAnalyse() {
        return fkIdAnalyse;
    }

    public void setFkIdAnalyse(Long fkIdAnalyse) {
        this.fkIdAnalyse = fkIdAnalyse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}



