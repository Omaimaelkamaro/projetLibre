package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    // Find a user by their email (this is actually handled by JpaRepository already)
    Optional<Utilisateur> findByEmail(String email);

    // Check if a user exists by their email
    boolean existsByEmail(String email);

    // Custom query to find users by their role (example, adjust according to your needs)
    List<Utilisateur> findByRole(String role);

    // If you have additional methods based on your application's needs, you can add them here
}
