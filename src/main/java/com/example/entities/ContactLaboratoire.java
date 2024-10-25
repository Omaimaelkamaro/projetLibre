package com.example.entities;
import jakarta.persistence.*;

@Entity
public class ContactLaboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkIdLaboratoire", nullable = false)
    private Laboratoire laboratoire;

    private int fkIdAdresse;
    private String numTel;
    private String fax;
    private String email;
	public Laboratoire getLaboratoire() {
		return laboratoire;
	}
	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}
	public int getFkIdAdresse() {
		return fkIdAdresse;
	}
	public void setFkIdAdresse(int fkIdAdresse) {
		this.fkIdAdresse = fkIdAdresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ContactLaboratoire(Laboratoire laboratoire, int fkIdAdresse, String numTel, String fax, String email) {
		super();
		this.laboratoire = laboratoire;
		this.fkIdAdresse = fkIdAdresse;
		this.numTel = numTel;
		this.fax = fax;
		this.email = email;
	}
	public ContactLaboratoire() {
		super();
	}

    
    
}
