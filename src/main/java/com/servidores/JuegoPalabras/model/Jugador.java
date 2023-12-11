package com.servidores.JuegoPalabras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    Integer id = null;
    String usuario;
    String puntos;
    Object avatar;
}
