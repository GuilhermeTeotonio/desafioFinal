package com.desafioFinal.futebol_api.repository;

import com.desafioFinal.futebol_api.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeAndSiglaEstado(String nome, String siglaEstado);
}