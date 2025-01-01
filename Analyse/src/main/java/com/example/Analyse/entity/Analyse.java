package com.example.Analyse.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Analyse_t")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nom;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

////
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Epreuve> getEpreuves() {
//        return epreuves;
//    }

//    public void setEpreuves(List<Epreuve> epreuves) {
//        this.epreuves = epreuves;
//    }

    public Analyse( String nom, String description) {
        super();
       // this.laboratoire = laboratoire;
        this.nom = nom;
        this.description = description;
       // this.epreuves = epreuves;
    }

    public Analyse() {
        super();
    }



}