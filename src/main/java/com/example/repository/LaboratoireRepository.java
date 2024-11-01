package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Laboratoire;

import java.util.List;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Integer> {

    // Find by name (case-insensitive)
    List<Laboratoire> findByNomIgnoreCase(String nom);

    // Find by active status
    List<Laboratoire> findByActive(boolean active);

    // Custom query to search by name or status
    @Query("SELECT l FROM Laboratoire l WHERE l.nom LIKE %:nom% OR l.active = :active")
    List<Laboratoire> searchByNomOrStatus(String nom, boolean active);
}
