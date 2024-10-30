package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UtilisateurDto;
import com.example.service.UtilisateurService;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/api/utilisateurs")

@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<UtilisateurDto> creerUtilisateur(@Valid @RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto utilisateurCree = utilisateurService.creerUtilisateur(utilisateurDto);
        return new ResponseEntity<>(utilisateurCree, HttpStatus.CREATED);
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurs = utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable String id) {
        UtilisateurDto utilisateur = utilisateurService. obtenirUtilisateurParId(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> mettreAJourUtilisateur(@PathVariable String id, @Valid @RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto utilisateurMisAJour = utilisateurService.modifierUtilisateur(id, utilisateurDto);
        return new ResponseEntity<>(utilisateurMisAJour, HttpStatus.OK);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable String id) {
        utilisateurService.supprimerUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
