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
        jugadorRepository.findById(jugador.getId()).orElseThrow(() -> new JugadorAlreadyExistsException(jugador.getId()));
        if (jugadorRepository.existsByUsuario(jugador.getUsuario())) {
            throw new JugadorAlreadyExistsException(jugador.getUsuario());
        }
        return new ResponseEntity<>(jugadorRepository.save(jugador), HttpStatus.CREATED);
    }

    @PutMapping("/jugadores/{id}")
    public ResponseEntity<?> update(@RequestBody Jugador jugador, @PathVariable Integer id) {
        if (jugador.getId() == null || jugador.getId().equals(id)) {
            jugadorRepository.findById(id).orElseThrow(() -> new JugadorNotFoundException(jugador.getId()));
            jugador.setId(id);
        }
        if (jugadorRepository.existsByUsuario(jugador.getUsuario())) {
            throw new JugadorAlreadyExistsException(jugador.getUsuario());
        }
        else {
            jugadorRepository.findById(jugador.getId()).orElseThrow(() -> new JugadorNotFoundException(id));
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
