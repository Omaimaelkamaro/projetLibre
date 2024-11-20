package com.example.userAuthentification.service;



import com.example.userAuthentification.dto.UtilisateurDto;
import com.example.userAuthentification.entity.User;
import com.example.userAuthentification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtService;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String save(User user) {
        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername());
        return token;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    public UtilisateurDto modifierUtilisateur(Long email, UtilisateurDto utilisateurDto) {
        Optional<User> optionalUtilisateur = userRepository.findById(email);
        if (optionalUtilisateur.isPresent()) {
            User utilisateur = optionalUtilisateur.get();
            // Update fields as necessary
            utilisateur.setUsername(utilisateurDto.getNomComplet());
            utilisateur.setProfession(utilisateurDto.getProfession());
            utilisateur.setNumTel(utilisateurDto.getNumTel());
            utilisateur.setSignature(utilisateurDto.getSignature());
            utilisateur.setRoles(Collections.singleton(utilisateurDto.getRole()));
            User updatedUtilisateur = userRepository.save(utilisateur);
            return mapToDto(updatedUtilisateur);
        }
        return null; // or throw an exception
    }

    public UtilisateurDto obtenirUtilisateurParId(Long email) {
        return userRepository.findById(email)
                .map(this::mapToDto) // Call non-static mapToDto method
                .orElse(null); // or throw an exception
    }

    public List<UtilisateurDto> obtenirTousLesUtilisateurs() {
        return userRepository.findAll().stream()
                .map(this::mapToDto) // Call non-static mapToDto method
                .collect(Collectors.toList());
    }

    public void supprimerUtilisateur(Long email) {
        userRepository.deleteById(email);
    }

    public List<UtilisateurDto> getAllUtilisateurs() {
        return obtenirTousLesUtilisateurs(); // Call the existing method
    }

    private User mapToEntity(UtilisateurDto utilisateurDto) {
        User utilisateur = new User();
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setUsername(utilisateurDto.getNomComplet());
        utilisateur.setProfession(utilisateurDto.getProfession());
        utilisateur.setNumTel(utilisateurDto.getNumTel());
        utilisateur.setSignature(utilisateurDto.getSignature());
        utilisateur.setRoles(Collections.singleton(utilisateurDto.getRole()));
        return utilisateur;
    }

    private UtilisateurDto mapToDto(User utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setEmail(utilisateur.getEmail());
        dto.setNomComplet(utilisateur.getUsername());
        dto.setProfession(utilisateur.getProfession());
        dto.setNumTel(utilisateur.getNumTel());
        dto.setSignature(utilisateur.getSignature());
        if (utilisateur.getRoles() != null && !utilisateur.getRoles().isEmpty()) {
            dto.setRole(utilisateur.getRoles().iterator().next()); // Take the first role
        }
        return dto;
    }
}
