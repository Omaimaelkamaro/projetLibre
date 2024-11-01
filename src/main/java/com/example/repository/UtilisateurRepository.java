package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    
    Optional<Utilisateur> findByEmail(String email);
    
    
    boolean existsByEmail(String email);
    
   
    List<Utilisateur> findByRole(String role);
    
   
}
