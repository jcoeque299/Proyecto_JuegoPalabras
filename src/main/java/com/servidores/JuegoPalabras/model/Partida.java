package com.servidores.JuegoPalabras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    Integer id = null;
    String palabra;
    Integer intentos;
    Integer puntos;
    LocalDateTime timestamp;
}
