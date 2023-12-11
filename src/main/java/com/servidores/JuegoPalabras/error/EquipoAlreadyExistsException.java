package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EquipoAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 43876691117560211L;
    public EquipoAlreadyExistsException(String equipo) {
        super("Equipo con nombre " + equipo + " ya existe");
    }
    public EquipoAlreadyExistsException(Integer id) {
        super("Equipo con id " + id + " ya existe");
    }
}
