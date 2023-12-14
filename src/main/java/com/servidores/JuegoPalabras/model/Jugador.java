package com.servidores.JuegoPalabras.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue
    Integer id = 0;
    String usuario;
    String puntos;
    String avatar;

    @ManyToOne
    @JoinColumn(name = "equipoId")
    Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    List<Partida> partidas;
}
