package com.servidores.JuegoPalabras.controller;

import com.servidores.JuegoPalabras.error.EquipoAlreadyExistsException;
import com.servidores.JuegoPalabras.error.EquipoNotFoundException;
import com.servidores.JuegoPalabras.model.Equipo;
import com.servidores.JuegoPalabras.repository.EquipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EquipoController {
    private final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @GetMapping("/equipos")
    public ResponseEntity<?> findAll() {return new ResponseEntity<>(equipoRepository.findAll(), HttpStatus.OK);}

    @PostMapping("/equipos")
    public ResponseEntity<?> create(@RequestBody Equipo equipo) {
        //Excepcion si el nombre del equipo o la ID especificada ya existen
        if (equipoRepository.existsByNombre(equipo.getNombre())) {
            throw new EquipoAlreadyExistsException(equipo.getNombre());
        }
        if (equipoRepository.existsById(equipo.getId())) {
            throw new EquipoAlreadyExistsException(equipo.getId());
        }
        return new ResponseEntity<>(equipoRepository.save(equipo), HttpStatus.CREATED);
    }

    @PutMapping("/equipos/{id}")
    public ResponseEntity<?> update(@RequestBody Equipo equipo, @PathVariable Integer id) {
        //Excepción si el equipo a editar no existe. Reasignar la misma ID si no se especifica o la especificada es la misma
        Equipo equipoReemplazar = equipoRepository.findById(id).orElseThrow(() -> new EquipoNotFoundException(id));
        //Excepción si el nombre del equipo ya existe y no es el mismo que ya tenía
        if (equipo.getNombre().compareTo(equipoReemplazar.getNombre()) != 0 && equipoRepository.existsByNombre(equipo.getNombre())) {
            throw new EquipoAlreadyExistsException(equipo.getNombre());
        }
        if (equipo.getId() == 0 || equipo.getId().equals(id)) {
            equipo.setId(id);
        }
        //Excepción si el equipo a reemplazar no se encuentra
        else {
            equipoRepository.findById(equipo.getId()).orElseThrow(() -> new EquipoNotFoundException(equipo.getId()));
            equipoRepository.deleteById(id);
        }
        return new ResponseEntity<>(equipoRepository.save(equipo), HttpStatus.OK);
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        equipoRepository.findById(id).orElseThrow(() -> new EquipoNotFoundException(id));
        equipoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
