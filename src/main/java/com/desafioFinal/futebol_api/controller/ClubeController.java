package com.desafioFinal.futebol_api.controller;

import com.desafioFinal.futebol_api.model.Clube;
import com.desafioFinal.futebol_api.service.ClubeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @Autowired
    private ClubeService clubeService;

    @PostMapping
    public ResponseEntity<?> cadastrarClube(@Valid @RequestBody Clube clube, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Inválidos: " + result.getFieldError().getDefaultMessage());
        }
        if (clubeService.existeClubeComMesmoNomeEEstado(clube.getNome(), clube.getSiglaEstado())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Time já cadastrado");
        }
        try {
            Clube clubeSalvo = clubeService.salvarClube(clube);
            return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClube(@PathVariable Long id) {
        try {
            Clube clube = clubeService.buscarClube(id);
            if (clube != null) {
                return ResponseEntity.ok(clube);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public List<Clube> listarClubes() {
        return clubeService.listarClubes();
    }
}
