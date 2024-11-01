package com.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkIdAnalyse", nullable = false)
    private Analyse analyse;

    private String nom;

    @OneToMany(mappedBy = "epreuve")
    private List<Examen> examens;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Analyse getAnalyse() {
		return analyse;
	}

	public void setAnalyse(Analyse analyse) {
		this.analyse = analyse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public Epreuve(Analyse analyse, String nom, List<Examen> examens) {
		super();
		this.analyse = analyse;
		this.nom = nom;
		this.examens = examens;
	}

	public Epreuve() {
		super();
	}

    
}
