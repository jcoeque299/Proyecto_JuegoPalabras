package com.servidores.JuegoPalabras.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue
    Integer id = 0;
    String nombre;
    String badge; //Cambiar por tipo de datos que maneje imagenes
    Integer puntos;

    @OneToMany(mappedBy = "equipo")
    List<Jugador> jugadores;
}
