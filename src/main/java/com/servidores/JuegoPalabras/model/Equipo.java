package com.servidores.JuegoPalabras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    Integer id = null;
    String nombre;
    Object badge; //Cambiar por tipo de datos que maneje imagenes
    Integer puntos;
}
