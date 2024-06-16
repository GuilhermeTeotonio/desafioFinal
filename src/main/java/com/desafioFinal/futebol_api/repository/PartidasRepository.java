package com.desafioFinal.futebol_api.repository;

import com.desafioFinal.futebol_api.models.Clube;
import com.desafioFinal.futebol_api.models.Estadio;
import com.desafioFinal.futebol_api.models.Partidas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidasRepository extends JpaRepository<Partidas, Long> {
    List<Partidas> findByClubeCasaOrClubeVisitante(Clube clubeCasa, Clube clubeVisitante);
    List<Partidas> findByEstadio(Estadio estadio);
}
