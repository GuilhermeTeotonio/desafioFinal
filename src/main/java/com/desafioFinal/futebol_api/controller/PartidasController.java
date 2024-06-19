package com.desafioFinal.futebol_api.controller;
import com.desafioFinal.futebol_api.model.Partidas;
import com.desafioFinal.futebol_api.service.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/partidas")
public class PartidasController {
    @Autowired
    private PartidasService partidasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Partidas salvarPartida(@RequestBody Partidas partidas) {
        return partidasService.salvarPartidas(partidas);
    }

    @PutMapping("/{id}")
    public Partidas editarPartida(@PathVariable Long id, @RequestBody Partidas partidas) {
        return partidasService.editarPartidas(id, partidas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPartidas(@PathVariable Long id) {
        partidasService.removerPartidas(id);
    }

    @GetMapping("/{id}")
    public Partidas buscarPartidas(@PathVariable Long id) {
        return partidasService.buscarPartidas(id);
    }

    @GetMapping
    public List<Partidas> listarPartidas() {
        return partidasService.listarPartidas();
    }
}
