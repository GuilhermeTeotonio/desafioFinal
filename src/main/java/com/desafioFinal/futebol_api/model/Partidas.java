package com.desafioFinal.futebol_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Partidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clube_casa_id")
    private Clube clubeCasa;

    @ManyToOne
    @JoinColumn(name = "clube_visitante_id")
    private Clube clubeVisitante;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @NotNull
    private LocalDateTime dataHora;

    private int golsCasa;
    private int golsVisitante;
}
