package com.example.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numDossier;

    @ManyToOne
    @JoinColumn(name = "refEmailUtilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "fkIdPatient", nullable = false)
    private Patient patient;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "dossier")
    private List<Examen> examens;

	public int getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public Dossier(Utilisateur utilisateur, Patient patient, Date date, List<Examen> examens) {
		super();
		this.utilisateur = utilisateur;
		this.patient = patient;
		this.date = date;
		this.examens = examens;
	}

	public Dossier() {
		super();
	}

    
}
