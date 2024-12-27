package com.example.contactLaboratoire.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "contacts_laboratoire")
public class ContactLaboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fk_id_laboratoire", nullable = false)
    private Long fkIdLaboratoire;

    @Column(name = "fk_id_adresse")
    private String fkIdAdresse;

    @Column(name = "num_tel", nullable = false)
    private String numTel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email", nullable = false)
    private String email;

    // Constructeur sans arguments
    public ContactLaboratoire() {
    }

    // Constructeur avec tous les arguments
    public ContactLaboratoire(Long id, Long fkIdLaboratoire, String fkIdAdresse, String numTel, String fax, String email) {
        this.id = id;
        this.fkIdLaboratoire = fkIdLaboratoire;
        this.fkIdAdresse = fkIdAdresse;
        this.numTel = numTel;
        this.fax = fax;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkIdLaboratoire() {
        return fkIdLaboratoire;
    }

    public void setFkIdLaboratoire(Long fkIdLaboratoire) {
        this.fkIdLaboratoire = fkIdLaboratoire;
    }

    public String getFkIdAdresse() {
        return fkIdAdresse;
    }

    public void setFkIdAdresse(String fkIdAdresse) {
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

    // Méthode toString
    @Override
    public String toString() {
        return "ContactLaboratoire{" +
                "id=" + id +
                ", fkIdLaboratoire=" + fkIdLaboratoire +
                ", fkIdAdresse='" + fkIdAdresse + '\'' +
                ", numTel='" + numTel + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

