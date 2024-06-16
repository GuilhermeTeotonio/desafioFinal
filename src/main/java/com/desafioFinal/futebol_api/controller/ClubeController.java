package com.desafioFinal.futebol_api.controller;

import com.desafioFinal.futebol_api.models.Clube;
import com.desafioFinal.futebol_api.services.ClubeService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    @Autowired
    private ClubeService clubeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clube salvarClube(@RequestBody Clube clube) {
        return clubeService.salvarClube(clube);
    }

    @PutMapping("/{id}")
    public Clube editarClube(@PathVariable Long id, @RequestBody Clube clube) {
        return clubeService.editarClube(id, clube);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativarClube(@PathVariable Long id) {
        clubeService.inativarClube(id);
    }

    @GetMapping("/{id}")
    public Clube buscarClube(@PathVariable Long id) {
        return clubeService.buscarClube(id);
    }

    @GetMapping
    public List<Clube> listarClubes() {
        return clubeService.listarClubes();
    }
}
