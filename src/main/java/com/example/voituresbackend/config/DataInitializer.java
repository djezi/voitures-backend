package com.example.voituresbackend.config;


import com.example.voituresbackend.entities.Categorie;
import com.example.voituresbackend.entities.Voiture;
import com.example.voituresbackend.repos.CategorieRepository;
import com.example.voituresbackend.repos.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    private final VoitureRepository voitureRepository;

    public DataInitializer(CategorieRepository categorieRepository, VoitureRepository voitureRepository) {
        this.categorieRepository = categorieRepository;
        this.voitureRepository = voitureRepository;
    }

    @Override
    public void run(String... args) {
        if (categorieRepository.count() > 0) {
            return;
        }
        Categorie v8 = categorieRepository.save(new Categorie(null, "v8"));
        Categorie rs = categorieRepository.save(new Categorie(null, "RS"));

        voitureRepository.save(new Voiture(null, "BMW", 50000.0, date("2018-07-30"), v8));
        voitureRepository.save(new Voiture(null, "AUDI", 60000.0, date("2019-05-12"), rs));
        voitureRepository.save(new Voiture(null, "MERCEDES", 75000.0, date("2020-01-15"), v8));
        voitureRepository.save(new Voiture(null, "RENAULT", 25000.0, date("2021-10-05"), rs));
    }

    private Date date(String iso) {
        return Date.from(LocalDate.parse(iso).atStartOfDay(ZoneOffset.UTC).toInstant());
    }
}