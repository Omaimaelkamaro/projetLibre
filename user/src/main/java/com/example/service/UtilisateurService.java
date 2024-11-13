package com.example.service;

import com.example.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto creerUtilisateur(UtilisateurDto utilisateurDto);
    UtilisateurDto modifierUtilisateur(String email, UtilisateurDto utilisateurDto); // Change Long to String
    UtilisateurDto obtenirUtilisateurParId(String email); // Change Long to String
    List<UtilisateurDto> obtenirTousLesUtilisateurs();
    void supprimerUtilisateur(String email); // Change Long to String
    List<UtilisateurDto> getAllUtilisateurs(); // This can be retained or removed based on your preference
}
