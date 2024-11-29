package com.example.Analyse.repository;

import com.example.Analyse.entity.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyseRepository extends JpaRepository<Analyse, Integer> {

    // Rechercher des analyses par nom (partiel ou complet)
    List<Analyse> findByNomContaining(String nom);

    // Rechercher des analyses par description (partiel ou complet)
    List<Analyse> findByDescriptionContaining(String description);

//    // Rechercher des analyses avec un nombre minimum d'épreuves associées
//    @Query("SELECT a FROM Analyse a WHERE SIZE(a.epreuves) >= :minEpreuves")
//    List<Analyse> findByMinEpreuves(int minEpreuves);

    // Rechercher des analyses associées à un laboratoire spécifique (si la relation est ajoutée)
    // @Query("SELECT a FROM Analyse a WHERE a.laboratoire.id = :laboratoireId")
    // List<Analyse> findByLaboratoireId(int laboratoireId);

//    // Rechercher des analyses par combinaison de critères (nom et description)
//    @Query("SELECT a FROM Analyse a WHERE a.nom LIKE %:nom% AND a.description LIKE %:description%")
//    List<Analyse> findByNomAndDescription(String nom, String description);

    // Rechercher toutes les analyses triées par nom
    List<Analyse> findAllByOrderByNomAsc();
}
