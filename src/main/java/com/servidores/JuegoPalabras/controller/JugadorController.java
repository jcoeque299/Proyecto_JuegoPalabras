package com.servidores.JuegoPalabras.controller;

import com.servidores.JuegoPalabras.error.JugadorAlreadyExistsException;
import com.servidores.JuegoPalabras.error.JugadorNotFoundException;
import com.servidores.JuegoPalabras.model.Jugador;
import com.servidores.JuegoPalabras.repository.JugadorRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JugadorController {
    private final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/jugadores")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(jugadorRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jugadores")
    public ResponseEntity<?> create(@RequestBody Jugador jugador) {
        if (jugadorRepository.existsByUsuario(jugador.getUsuario())) {
            throw new JugadorAlreadyExistsException(jugador.getUsuario());
        }
        if (jugadorRepository.existsById(jugador.getId())) {
            throw new JugadorAlreadyExistsException(jugador.getId());
        }
        return new ResponseEntity<>(jugadorRepository.save(jugador), HttpStatus.CREATED);
    }

    @PutMapping("/jugadores/{id}")
    public ResponseEntity<?> update(@RequestBody Jugador jugador, @PathVariable Integer id) {
        Jugador jugadorReemplazar = jugadorRepository.findById(id).orElseThrow(() -> new JugadorNotFoundException(id));
        if (jugador.getUsuario().compareTo(jugadorReemplazar.getUsuario()) != 0 && jugadorRepository.existsByUsuario(jugador.getUsuario())) {
            throw new JugadorAlreadyExistsException(jugador.getUsuario());
        }
        if (jugador.getId() == 0 || jugador.getId().equals(id)) {
            jugador.setId(id);
        }
        else {
            jugadorRepository.findById(jugador.getId()).orElseThrow(() -> new JugadorNotFoundException(jugador.getId()));
            jugadorRepository.deleteById(id);
        }
        return new ResponseEntity<>(jugadorRepository.save(jugador), HttpStatus.OK);
    }
    @DeleteMapping("/jugadores/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        jugadorRepository.findById(id).orElseThrow(() -> new JugadorNotFoundException(id));
        jugadorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
