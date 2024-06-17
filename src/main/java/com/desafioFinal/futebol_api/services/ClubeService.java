package com.desafioFinal.futebol_api.services;

import com.desafioFinal.futebol_api.models.Clube;
import com.desafioFinal.futebol_api.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClubeService {
    @Autowired
    private ClubeRepository clubeRepository;

    public Clube salvarClube(Clube clube) {
        if (clubeRepository.existsByNomeAndSiglaEstado(clube.getNome(), clube.getSiglaEstado())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Clube já existe no estado especificado");
        }
        return clubeRepository.save(clube);
    }

    public Clube editarClube(Long id, Clube clube) {
        Clube clubeExistente = clubeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado"));
        // Validar e atualizar os dados do clube existente
        return clubeRepository.save(clubeExistente);
    }

    public void inativarClube(Long id) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado"));
        clube.setAtivo(false);
        clubeRepository.save(clube);
    }

    public Clube buscarClube(Long id) {
        return clubeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado"));
    }

    public List<Clube> listarClubes() {
        return clubeRepository.findAll();
    }
}
