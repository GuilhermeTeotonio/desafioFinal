package com.desafioFinal.futebol_api.repository;

import com.desafioFinal.futebol_api.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {
    boolean existsByNome(String nome);
}
