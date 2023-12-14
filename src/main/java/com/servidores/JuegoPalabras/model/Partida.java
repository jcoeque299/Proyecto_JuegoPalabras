package com.servidores.JuegoPalabras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    Integer id = 0;
    Integer intentos;
    Integer puntos;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    LocalDateTime timestamp = LocalDateTime.now();

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
