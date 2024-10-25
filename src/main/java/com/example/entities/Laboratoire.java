package com.example.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    private String logo;
    private String rnc;
    private boolean active;

    @Temporal(TemporalType.DATE)
    private Date dateActivation;

    @OneToMany(mappedBy = "laboratoire")
    private List<ContactLaboratoire> contacts;

    @OneToMany(mappedBy = "laboratoire")
    private List<Analyse> analyses;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRnc() {
		return rnc;
	}

	public void setRnc(String rnc) {
		this.rnc = rnc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public List<ContactLaboratoire> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactLaboratoire> contacts) {
		this.contacts = contacts;
	}

	public List<Analyse> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}

	public Laboratoire(String nom, String logo, String rnc, boolean active, Date dateActivation,
			List<ContactLaboratoire> contacts, List<Analyse> analyses) {
		super();
		this.nom = nom;
		this.logo = logo;
		this.rnc = rnc;
		this.active = active;
		this.dateActivation = dateActivation;
		this.contacts = contacts;
		this.analyses = analyses;
	}

	public Laboratoire() {
		super();
	}

   
    
}
