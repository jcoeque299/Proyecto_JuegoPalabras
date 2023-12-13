package com.servidores.JuegoPalabras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue
    Integer id = null;
    String nombre;
    String badge; //Cambiar por tipo de datos que maneje imagenes
    Integer puntos;

    @OneToMany(mappedBy = "equipo")
    List<Jugador> jugadores;
}
