package com.example.Epreuve.client;

public class AnalyseDto {
    private int id;


    private String nom;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


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
    public AnalyseDto( String nom, String description) {
        super();
        // this.laboratoire = laboratoire;
        this.nom = nom;
        this.description = description;
        // this.epreuves = epreuves;
    }

    public AnalyseDto() {
        super();
    }
}
