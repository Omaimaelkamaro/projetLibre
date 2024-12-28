package com.example.Adresse.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numVoie;
    private String nomVoie;
    private String codePostal;
    private String ville;
    private String commune;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumVoie() {
        return numVoie;
    }
    public void setNumVoie(String numVoie) {
        this.numVoie = numVoie;
    }
    public String getNomVoie() {
        return nomVoie;
    }
    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getCommune() {
        return commune;
    }
    public void setCommune(String commune) {
        this.commune = commune;
    }
    public Adresse(String nomVoie, String codePostal, String ville, String commune) {
        super();

        this.nomVoie = nomVoie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.commune = commune;
    }
    public Adresse() {
        super();
    }



}
