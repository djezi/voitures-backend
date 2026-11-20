package com.example.voituresbackend.restControllers;

import com.example.voituresbackend.entities.Categorie;
import com.example.voituresbackend.service.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieRestController {

    private final CategorieService categorieService;

    public CategorieRestController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getAll() {
        return categorieService.getAll();
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable Long id) {
        return categorieService.getById(id);
    }

    @PostMapping
    public Categorie create(@RequestBody Categorie c) {
        return categorieService.create(c);
    }

    @PutMapping("/{id}")
    public Categorie update(@PathVariable Long id, @RequestBody Categorie c) {
        return categorieService.update(id, c);
    }
}