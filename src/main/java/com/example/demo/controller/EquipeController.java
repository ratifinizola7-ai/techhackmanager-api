package com.example.demo.controller;

import com.example.demo.model.Equipe;
import com.example.demo.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> listarTodas() {
        return equipeRepository.findAll();
    }

    @PostMapping
    public Equipe criarEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
