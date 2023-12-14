package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JugadorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43876691007560211L;
    public JugadorNotFoundException(String usuario) {
        super("Jugador con usuario" + usuario + " no existe");
    }
    public JugadorNotFoundException(Integer id) {super("Jugador con id " + id + " no existe");}
}
