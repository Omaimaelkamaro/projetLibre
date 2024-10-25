package com.example.entities;
import jakarta.persistence.*;

import jakarta.persistence.Entity;

@Entity
public class Utilisateur {
    @Id
    private String email;

    @ManyToOne
    @JoinColumn(name = "fkIdLaboratoire", nullable = false)
    private Laboratoire laboratoire;

    private String nomComplet;
    private String profession;
    private String numTel;
    private String signature;
    private String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Laboratoire getLaboratoire() {
		return laboratoire;
	}
	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Utilisateur(Laboratoire laboratoire, String nomComplet, String profession, String numTel, String signature,
			String role) {
		super();
		this.laboratoire = laboratoire;
		this.nomComplet = nomComplet;
		this.profession = profession;
		this.numTel = numTel;
		this.signature = signature;
		this.role = role;
	}
	public Utilisateur() {
		super();
	}

    
    
}

