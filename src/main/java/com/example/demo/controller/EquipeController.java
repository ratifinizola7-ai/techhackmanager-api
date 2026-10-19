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

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> buscarPorId(@PathVariable Long id) {
        return equipeRepository.findById(id)
                .map(equipe -> ResponseEntity.ok(equipe))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> atualizarEquipe(@PathVariable Long id, @RequestBody @Valid Equipe equipeAtualizada) {
        return equipeRepository.findById(id)
                .map(equipeExistente -> {
                    equipeExistente.setNome(equipeAtualizada.getNome());
                    equipeExistente.setProjeto(equipeAtualizada.getProjeto());
                    equipeExistente.setNotaFinal(equipeAtualizada.getNotaFinal());
                    Equipe equipeSalva = equipeRepository.save(equipeExistente);
                    return ResponseEntity.ok(equipeSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarEquipe(@PathVariable Long id) {
        if (equipeRepository.existsById(id)) {
            equipeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}