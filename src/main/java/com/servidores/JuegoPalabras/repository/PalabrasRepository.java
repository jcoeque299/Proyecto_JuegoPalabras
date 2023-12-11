package com.servidores.JuegoPalabras.repository;

import com.servidores.JuegoPalabras.model.Palabras;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.ListCrudRepository;

public interface PalabrasRepository extends ListCrudRepository<Palabras, Integer> {
}
