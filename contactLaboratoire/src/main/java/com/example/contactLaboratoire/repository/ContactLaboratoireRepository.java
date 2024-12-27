package com.example.contactLaboratoire.repository;



import com.example.contactLaboratoire.entity.ContactLaboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactLaboratoireRepository extends JpaRepository<ContactLaboratoire, Long> {
    List<ContactLaboratoire> findByFkIdLaboratoire(Long fkIdLaboratoire);
}
