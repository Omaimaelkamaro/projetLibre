package com.example.service.impl;

import com.example.dto.UtilisateurDto;
import com.example.entities.Utilisateur;
import com.example.repository.UtilisateurRepository;
import com.example.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto creerUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = mapToEntity(utilisateurDto);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return mapToDto(savedUtilisateur);
    }

    @Override
    public UtilisateurDto modifierUtilisateur(String email, UtilisateurDto utilisateurDto) { // Updated to String email
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(email);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            // Update fields as necessary
            utilisateur.setNomComplet(utilisateurDto.getNomComplet());
            utilisateur.setProfession(utilisateurDto.getProfession());
            utilisateur.setNumTel(utilisateurDto.getNumTel());
            utilisateur.setSignature(utilisateurDto.getSignature());
            utilisateur.setRole(utilisateurDto.getRole());
            Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
            return mapToDto(updatedUtilisateur);
        }
        return null; // or throw an exception
    }

    @Override
    public UtilisateurDto obtenirUtilisateurParId(String email) { // Updated to String email
        return utilisateurRepository.findById(email)
                .map(this::mapToDto)
                .orElse(null); // or throw an exception
    }

    @Override
    public List<UtilisateurDto> obtenirTousLesUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimerUtilisateur(String email) { // Updated to String email
        utilisateurRepository.deleteById(email);
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        return obtenirTousLesUtilisateurs(); // Call the existing method
    }

    // Helper method to map UtilisateurDto to Utilisateur entity
    private Utilisateur mapToEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setNomComplet(utilisateurDto.getNomComplet());
        utilisateur.setProfession(utilisateurDto.getProfession());
        utilisateur.setNumTel(utilisateurDto.getNumTel());
        utilisateur.setSignature(utilisateurDto.getSignature());
        utilisateur.setRole(utilisateurDto.getRole());
        // Set Laboratoire if needed
        return utilisateur;
    }

    // Helper method to map Utilisateur to UtilisateurDto
    private UtilisateurDto mapToDto(Utilisateur utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setEmail(utilisateur.getEmail());
        dto.setNomComplet(utilisateur.getNomComplet());
        dto.setProfession(utilisateur.getProfession());
        dto.setNumTel(utilisateur.getNumTel());
        dto.setSignature(utilisateur.getSignature());
        dto.setRole(utilisateur.getRole());
        // Set Laboratoire ID if needed
        return dto;
    }
}
