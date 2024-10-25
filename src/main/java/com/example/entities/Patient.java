package com.example.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomComplet;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String lieuNaissance;
    private String sexe;
    private String typePieceIdentite;
    private String numPieceIdentite;
    private String adresse;
    private String numTel;
    private String email;
    private String visiblePour;
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTypePieceIdentite() {
		return typePieceIdentite;
	}
	public void setTypePieceIdentite(String typePieceIdentite) {
		this.typePieceIdentite = typePieceIdentite;
	}
	public String getNumPieceIdentite() {
		return numPieceIdentite;
	}
	public void setNumPieceIdentite(String numPieceIdentite) {
		this.numPieceIdentite = numPieceIdentite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVisiblePour() {
		return visiblePour;
	}
	public void setVisiblePour(String visiblePour) {
		this.visiblePour = visiblePour;
	}
	public Patient(String nomComplet, Date dateNaissance, String lieuNaissance, String sexe, String typePieceIdentite,
			String numPieceIdentite, String adresse, String numTel, String email, String visiblePour) {
		super();
		this.nomComplet = nomComplet;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.typePieceIdentite = typePieceIdentite;
		this.numPieceIdentite = numPieceIdentite;
		this.adresse = adresse;
		this.numTel = numTel;
		this.email = email;
		this.visiblePour = visiblePour;
	}
	public Patient() {
		super();
	}

    
}
