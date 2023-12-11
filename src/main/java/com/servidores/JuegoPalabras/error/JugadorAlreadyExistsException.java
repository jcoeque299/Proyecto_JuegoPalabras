package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class JugadorAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 43876691117560211L;
    public JugadorAlreadyExistsException(String usuario) {
        super("Jugador con nombre " + usuario + " ya existe");
    }
    public JugadorAlreadyExistsException(Integer id) {
        super("Jugador con id " + id + " ya existe");
    }
}
