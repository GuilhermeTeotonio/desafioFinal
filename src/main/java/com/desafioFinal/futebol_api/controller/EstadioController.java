package com.desafioFinal.futebol_api.controller;

import com.desafioFinal.futebol_api.model.Estadio;
import com.desafioFinal.futebol_api.service.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
    @Autowired
    private EstadioService estadioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estadio salvarEstadio(@RequestBody Estadio estadio) {
        return estadioService.salvarEstadio(estadio);
    }

    @PutMapping("/{id}")
    public Estadio editarEstadio(@PathVariable Long id, @RequestBody Estadio estadio) {
        return estadioService.editarEstadio(id, estadio);
    }

    @GetMapping("/{id}")
    public Estadio buscarEstadio(@PathVariable Long id) {
        return estadioService.buscarEstadio(id);
    }

    @GetMapping
    public List<Estadio> listarEstadios() {
        return estadioService.listarEstadios();
    }
}
