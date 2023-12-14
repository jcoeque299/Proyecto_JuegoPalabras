package com.servidores.JuegoPalabras.controller;

import com.servidores.JuegoPalabras.error.PartidaAlreadyExistsException;
import com.servidores.JuegoPalabras.error.PartidaNotFoundException;
import com.servidores.JuegoPalabras.model.Partida;
import com.servidores.JuegoPalabras.repository.PartidaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartidaController {
    private final PartidaRepository partidaRepository;

    public PartidaController(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @GetMapping("/partidas")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(partidaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/partidas")
    public ResponseEntity<?> create(@RequestBody Partida partida) {
        if (partidaRepository.existsById(partida.getId())) {
            throw new PartidaAlreadyExistsException(partida.getId());
        }
        return new ResponseEntity<>(partidaRepository.save(partida), HttpStatus.CREATED);
    }

    @PutMapping("/partidas/{id}")
    public ResponseEntity<?> update(@RequestBody Partida partida, @PathVariable Integer id) {
        Partida partidaReemplazar = partidaRepository.findById(id).orElseThrow(() -> new PartidaNotFoundException(id));
        if (partida.getId() == 0 || partida.getId().equals(id)) {
            partida.setId(id);
        }
        else {
            partidaRepository.findById(partida.getId()).orElseThrow(() -> new PartidaNotFoundException(partida.getId()));
            partidaRepository.deleteById(id);
        }
        return new ResponseEntity<>(partidaRepository.save(partida), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        partidaRepository.findById(id).orElseThrow(() -> new PartidaNotFoundException(id));
        partidaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
