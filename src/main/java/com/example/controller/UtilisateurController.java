package com.example.controller;


import com.example.dto.UtilisateurDto;
import com.example.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
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
