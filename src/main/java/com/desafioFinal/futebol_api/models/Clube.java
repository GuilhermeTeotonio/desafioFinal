package com.desafioFinal.futebol_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2)
    private String nome;

    @NotNull
    @Size(min = 2, max = 2)
    private String siglaEstado;

    @NotNull
    @PastOrPresent
    private LocalDate dataCriacao;

    private boolean ativo;

    // Getters e Setters
}