package com.servidores.JuegoPalabras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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
