package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Juegos;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosRepository extends ListCrudRepository<Juegos, Integer> {
}
