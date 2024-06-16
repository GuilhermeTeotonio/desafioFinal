package com.desafioFinal.futebol_api.services;

import com.desafioFinal.futebol_api.models.Partidas;
import com.desafioFinal.futebol_api.repository.ClubeRepository;
import com.desafioFinal.futebol_api.repository.EstadioRepository;
import com.desafioFinal.futebol_api.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;

@Service
public class PartidasService {
    @Autowired
    private PartidasRepository partidaRepository;

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    public Partidas salvarPartida(Partidas partida) {
        // Validar clubes, estádio e outras regras de negócio
        return partidaRepository.save(partida);
    }

    public Partidas editarPartida(Long id, Partidas partida) {
        Partidas partidaExistente = partidaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
        // Validar e atualizar os dados da partida existente
        return partidaRepository.save(partidaExistente);
    }

    public void removerPartida(Long id) {
        Partidas partida = partidaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
        partidaRepository.delete(partida);
    }

    public Partidas buscarPartida(Long id) {
        return partidaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
    }

    public List<Partidas> listarPartidas() {
        return partidaRepository.findAll();
    }
}
