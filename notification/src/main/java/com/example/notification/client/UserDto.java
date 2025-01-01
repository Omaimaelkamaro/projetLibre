package com.example.notification.client;



import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;

import java.util.Set;

public class UserDto {
    private Long id;

    private String username;
    private String email;
    private String password;
    private boolean isActive;
    private String profession;
    private String numTel;
    private String signature;

    private long fkIdLaboratoire ;
    public enum Role {
        ADMIN,
        USER,

    }
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING) // Stocke les noms des rôles comme des chaînes dans la base de données
    private Set<Role> roles;
    public UserDto() {}

    public UserDto(String username, String email, String password, boolean isActive, Set<Role> roles,long fkIdLaboratoire ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
        this.fkIdLaboratoire= fkIdLaboratoire;
    }

    public UserDto(String email, Long id, boolean isActive, String numTel, String password, String profession, Set<Role> roles, String signature, String username,Long fkIdLaboratoire) {
        this.email = email;
        this.id = id;
        this.isActive = isActive;
        this.numTel = numTel;
        this.password = password;
        this.profession = profession;
        this.roles = roles;
        this.signature = signature;
        this.username = username;
        this.fkIdLaboratoire = fkIdLaboratoire;
    }
// Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getfkIdLaboratoire() {
        return fkIdLaboratoire;
    }

    public void setfkIdLaboratoire(Long fkIdLaboratoire) {
        this.fkIdLaboratoire = fkIdLaboratoire;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getProfession() {
        return profession;
    }

    public String getSignature() {
        return signature;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}




