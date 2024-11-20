package com.example.Adresse.Repository;

import com.example.Adresse.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    List<Adresse> findByVille(String ville);
    List<Adresse> findByNomVoie(String nomVoie);
}
