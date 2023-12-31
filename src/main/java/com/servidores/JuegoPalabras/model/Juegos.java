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
public class Juegos {
    @Id
    @GeneratedValue
    Integer id;
    String dificultad;
    String descripcion;
    Integer intentosMaximos;

    @OneToMany(mappedBy = "juego")
    List<Partida> partidas;
}
