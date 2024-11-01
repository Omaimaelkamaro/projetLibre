package com.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Analyse_table")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkIdLaboratoire", nullable = false)
    private Laboratoire laboratoire;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "analyse")
    private List<Epreuve> epreuves;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
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

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

	public Analyse(Laboratoire laboratoire, String nom, String description, List<Epreuve> epreuves) {
		super();
		this.laboratoire = laboratoire;
		this.nom = nom;
		this.description = description;
		this.epreuves = epreuves;
	}

	public Analyse() {
		super();
	}

   
    
}