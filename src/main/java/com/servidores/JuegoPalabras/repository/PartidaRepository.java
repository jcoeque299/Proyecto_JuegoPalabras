package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Partida;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends ListCrudRepository<Partida, Integer> {
}
