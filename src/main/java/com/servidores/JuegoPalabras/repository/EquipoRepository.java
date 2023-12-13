package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Equipo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends ListCrudRepository<Equipo, Integer> {
    Boolean existsByNombre(String nombre);
}
