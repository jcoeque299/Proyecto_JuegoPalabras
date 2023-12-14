package com.servidores.JuegoPalabras.controller;

import com.servidores.JuegoPalabras.repository.JuegosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JuegosController {
    private final JuegosRepository juegosRepository;

    public JuegosController(JuegosRepository juegosRepository) {
        this.juegosRepository = juegosRepository;
    }

    @GetMapping("/juegos")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(juegosRepository.findAll(), HttpStatus.OK);
    }
}
