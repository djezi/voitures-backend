package com.example.voituresbackend.restControllers;



import com.example.voituresbackend.entities.Voiture;
import com.example.voituresbackend.service.VoitureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
public class VoitureRestController {

    private final VoitureService voitureService;

    public VoitureRestController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping
    public List<Voiture> getAll() {
        return voitureService.getAll();
    }

    @GetMapping("/{id}")
    public Voiture getById(@PathVariable Long id) {
        return voitureService.getById(id);
    }

    @GetMapping("/cat/{idCat}")
    public List<Voiture> getByCategorie(@PathVariable Long idCat) {
        return voitureService.getByCategorie(idCat);
    }

    @GetMapping("/search")
    public List<Voiture> search(@RequestParam String nom) {
        return voitureService.searchByNom(nom);
    }

    @PostMapping
    public Voiture create(@RequestBody Voiture v) {
        return voitureService.create(v);
    }

    @PutMapping("/{id}")
    public Voiture update(@PathVariable Long id, @RequestBody Voiture v) {
        return voitureService.update(id, v);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        voitureService.delete(id);
    }
}