package com.servidores.JuegoPalabras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Juegos {
    @Id
    @GeneratedValue
    Integer id = null;
    String dificultad;
    String descripcion;
    Integer intentosMaximos;

    @OneToMany(mappedBy = "juego")
    List<Partida> partidas;
}
