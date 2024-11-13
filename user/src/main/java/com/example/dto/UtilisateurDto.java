package com.example.dto;

public class UtilisateurDto {
	private String email;           // Unique identifier
	private String nomComplet;      // Full name
	private String profession;       // Profession
	private String numTel;          // Phone number
	private String signature;        // Signature (could be a base64 string)
	private String role;            // User role
	private Long laboratoireId;      // Assuming you want to send the ID of the Laboratoire

	// Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getLaboratoireId() {
		return laboratoireId;
	}

	public void setLaboratoireId(Long laboratoireId) {
		this.laboratoireId = laboratoireId;
	}
}
