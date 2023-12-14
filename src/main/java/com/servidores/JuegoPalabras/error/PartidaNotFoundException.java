package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PartidaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43876691007560211L;
    public PartidaNotFoundException(Integer id) {super("Partida con id " + id + " no existe");}
}
