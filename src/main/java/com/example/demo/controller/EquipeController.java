package com.example.demo.controller;

import com.example.demo.model.Equipe;
import com.example.demo.repository.EquipeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    private final EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @PostMapping
    public ResponseEntity<Equipe> criarEquipe(@RequestBody @Valid Equipe equipe) {
        Equipe novaEquipe = equipeRepository.save(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEquipe);
    }

    @GetMapping
    public List<Equipe> listarEquipes() {
        return equipeRepository.findAll();
    }
}