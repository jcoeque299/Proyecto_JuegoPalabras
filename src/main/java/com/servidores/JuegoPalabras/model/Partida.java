package com.servidores.JuegoPalabras.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    @Id
    @GeneratedValue
    Integer id = null;
    String palabra;
    Integer intentos;
    Integer puntos;
    LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "juegoId")
    Juegos juego;

    @ManyToOne
    @JoinColumn(name = "jugadorId")
    Jugador jugador;

    @ManyToMany
    @JoinTable(
            name = "partida_palabras",
            joinColumns = @JoinColumn(name = "partidaId"),
            inverseJoinColumns = @JoinColumn(name = "palabraId")
    )
    List<Palabras> palabras;
}
