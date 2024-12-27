package com.example.Dossier.repository;




import com.example.Dossier.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
    List<Dossier> findByFkEmailUtilisateur(String fkEmailUtilisateur);
    List<Dossier> findByArchivé(boolean archivé);
}
