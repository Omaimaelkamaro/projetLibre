package com.example.Epreuve.Repository;




import com.example.Epreuve.entity.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, Long> {
    List<Epreuve> findByFkIdAnalyse(Long fkIdAnalyse);

    List<Epreuve> findByNomContainingIgnoreCase(String nom);
}



