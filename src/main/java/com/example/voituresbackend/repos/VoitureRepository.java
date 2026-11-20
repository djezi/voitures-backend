package com.example.voituresbackend.repos;


import com.example.voituresbackend.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByCategorieIdCat(Long idCat);
    List<Voiture> findByNomVoitureContainingIgnoreCase(String nom);
}