package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Optional<Utilisateur> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    List<Utilisateur> findByRole(String role);
    
    Page<Utilisateur> findByRole(String role, Pageable pageable);
    
    @Query("SELECT u FROM Utilisateur u WHERE u.role = :role AND u.active = true")
    List<Utilisateur> findActiveUsersByRole(@Param("role") String role);
    
    // Add more methods as needed
}
