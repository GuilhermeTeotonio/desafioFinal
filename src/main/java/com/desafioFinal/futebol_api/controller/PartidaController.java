package com.desafioFinal.futebol_api.controller;
import com.desafioFinal.futebol_api.models.Partidas;
import com.desafioFinal.futebol_api.services.PartidasService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @Autowired
    private PartidasService partidaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Partidas salvarPartida(@RequestBody Partidas partida) {
        return partidaService.salvarPartida(partida);
    }

    @PutMapping("/{id}")
    public Partidas editarPartida(@PathVariable Long id, @RequestBody Partidas partidas) {
        return partidaService.editarPartida(id, partidas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPartida(@PathVariable Long id) {
        partidaService.removerPartida(id);
    }

    @GetMapping("/{id}")
    public Partidas buscarPartida(@PathVariable Long id) {
        return partidaService.buscarPartida(id);
    }

    @GetMapping
    public List<Partidas> listarPartidas() {
        return partidaService.listarPartidas();
    }
}
