package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JugadorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43876691007560211L;
    public JugadorNotFoundException(String palabra) {
        super(palabra + " no existe");
    }
    public JugadorNotFoundException(Integer id) {super("Palabra con id " + id + " ya existe");}
}
