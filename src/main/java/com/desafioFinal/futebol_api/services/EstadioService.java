package com.desafioFinal.futebol_api.services;

import com.desafioFinal.futebol_api.models.Estadio;
import com.desafioFinal.futebol_api.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstadioService {
    @Autowired
    private EstadioRepository estadioRepository;

    public Estadio salvarEstadio(Estadio estadio) {
        if (estadioRepository.existsByNome(estadio.getNome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Estádio já existe");
        }
        return estadioRepository.save(estadio);
    }

    public Estadio editarEstadio(Long id, Estadio estadio) {
        Estadio estadioExistente = estadioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estádio não encontrado"));
        // Validar e atualizar os dados do estádio existente
        return estadioRepository.save(estadioExistente);
    }

    public Estadio buscarEstadio(Long id) {
        return estadioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estádio não encontrado"));
    }

    public List<Estadio> listarEstadios() {
        return estadioRepository.findAll();
    }
}
