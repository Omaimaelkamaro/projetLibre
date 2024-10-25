package com.example.entities;
import jakarta.persistence.*;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkNumDossier", nullable = false)
    private Dossier dossier;

    @ManyToOne
    @JoinColumn(name = "fkIdEpreuve", nullable = false)
    private Epreuve epreuve;

    @ManyToOne
    @JoinColumn(name = "fkIdTestAnalyse", nullable = false)
    private TestAnalyse testAnalyse;

    private String resultat;

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public TestAnalyse getTestAnalyse() {
		return testAnalyse;
	}

	public void setTestAnalyse(TestAnalyse testAnalyse) {
		this.testAnalyse = testAnalyse;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Examen(Dossier dossier, Epreuve epreuve, TestAnalyse testAnalyse, String resultat) {
		super();
		this.dossier = dossier;
		this.epreuve = epreuve;
		this.testAnalyse = testAnalyse;
		this.resultat = resultat;
	}

	public Examen() {
		super();
	}

    
}
