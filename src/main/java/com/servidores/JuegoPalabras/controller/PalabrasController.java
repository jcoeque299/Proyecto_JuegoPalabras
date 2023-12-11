package com.servidores.JuegoPalabras.controller;

import com.servidores.JuegoPalabras.repository.PalabrasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PalabrasController {
    private final PalabrasRepository palabrasRepository;

    public PalabrasController(PalabrasRepository palabrasRepository) {
        this.palabrasRepository = palabrasRepository;
    }

    @GetMapping("/palabras")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(palabrasRepository.findAll(), HttpStatus.OK);
    }
}
