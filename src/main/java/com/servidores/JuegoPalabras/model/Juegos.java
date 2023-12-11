package com.servidores.JuegoPalabras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Juegos {
    Integer id = null;
    String dificultad;
    String descripcion;
    Integer intentosMaximos;
}
