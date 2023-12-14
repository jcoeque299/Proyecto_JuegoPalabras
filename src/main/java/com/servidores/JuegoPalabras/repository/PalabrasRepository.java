package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Palabras;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalabrasRepository extends ListCrudRepository<Palabras, Integer> {
    List<Palabras> findByPalabraContains(String stringMatch);
    List<Palabras> findByPalabraStartsWith(String stringStartsWith);
}
