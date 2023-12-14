package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PartidaAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 43876691117560211L;
    public PartidaAlreadyExistsException(Integer id) {
        super("Partida con id " + id + " ya existe");
    }
}
