package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Jugador;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends ListCrudRepository<Jugador, Integer> {
    Boolean existsByUsuario(String usuario);
}
