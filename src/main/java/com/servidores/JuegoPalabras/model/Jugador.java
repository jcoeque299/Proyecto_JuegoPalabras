package com.servidores.JuegoPalabras.model;

import jakarta.persistence.*;
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
public class Jugador {
    @Id
    @GeneratedValue
    Integer id = null;
    String usuario;
    String puntos;
    Object avatar;

    @ManyToOne
    @JoinColumn(name = "equipoId")
    Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    List<Partida> partidas;
}
