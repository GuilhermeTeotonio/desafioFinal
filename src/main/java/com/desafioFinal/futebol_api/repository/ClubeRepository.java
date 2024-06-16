package com.desafioFinal.futebol_api.repository;

import com.desafioFinal.futebol_api.models.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeAndSiglaEstado(String nome, String siglaEstado);
}