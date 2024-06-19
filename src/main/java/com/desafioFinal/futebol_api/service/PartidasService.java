package com.desafioFinal.futebol_api.service;
import com.desafioFinal.futebol_api.model.Partidas;
import com.desafioFinal.futebol_api.repository.ClubeRepository;
import com.desafioFinal.futebol_api.repository.EstadioRepository;
import com.desafioFinal.futebol_api.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class PartidasService {
    @Autowired
    private PartidasRepository partidasRepository;

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    public Partidas salvarPartidas(Partidas partida) {
        // Validar clubes, estádio e outras regras de negócio
        return partidasRepository.save(partida);
    }

    public Partidas editarPartidas(Long id, Partidas partidas) {
        Partidas partidaExistente = partidasRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
        // Validar e atualizar os dados da partidas existente
        return partidasRepository.save(partidaExistente);
    }

    public void removerPartidas(Long id) {
        Partidas partida = partidasRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
        partidasRepository.delete(partida);
    }

    public Partidas buscarPartidas(Long id) {
        return partidasRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
    }

    public List<Partidas> listarPartidas() {
        return partidasRepository.findAll();
    }
}
