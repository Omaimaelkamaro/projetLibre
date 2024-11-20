package com.example.Laboratoire.repository;

import com.example.Laboratoire.entity.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
