package com.example.entities;
import jakarta.persistence.*;

@Entity
public class TestAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkIdAnalyse", nullable = false)
    private Analyse analyse;

    private String nomTest;
    private String sousEpreuve;
    private String intervalMinDeReference;
    private String intervalMaxDeReference;
    private String uniteDeReference;
    private String details;
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
	public String getNomTest() {
		return nomTest;
	}
	public void setNomTest(String nomTest) {
		this.nomTest = nomTest;
	}
	public String getSousEpreuve() {
		return sousEpreuve;
	}
	public void setSousEpreuve(String sousEpreuve) {
		this.sousEpreuve = sousEpreuve;
	}
	public String getIntervalMinDeReference() {
		return intervalMinDeReference;
	}
	public void setIntervalMinDeReference(String intervalMinDeReference) {
		this.intervalMinDeReference = intervalMinDeReference;
	}
	public String getIntervalMaxDeReference() {
		return intervalMaxDeReference;
	}
	public void setIntervalMaxDeReference(String intervalMaxDeReference) {
		this.intervalMaxDeReference = intervalMaxDeReference;
	}
	public String getUniteDeReference() {
		return uniteDeReference;
	}
	public void setUniteDeReference(String uniteDeReference) {
		this.uniteDeReference = uniteDeReference;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public TestAnalyse(Analyse analyse, String nomTest, String sousEpreuve, String intervalMinDeReference,
			String intervalMaxDeReference, String uniteDeReference, String details) {
		super();
		this.analyse = analyse;
		this.nomTest = nomTest;
		this.sousEpreuve = sousEpreuve;
		this.intervalMinDeReference = intervalMinDeReference;
		this.intervalMaxDeReference = intervalMaxDeReference;
		this.uniteDeReference = uniteDeReference;
		this.details = details;
	}
	public TestAnalyse() {
		super();
	}

   
    
}
