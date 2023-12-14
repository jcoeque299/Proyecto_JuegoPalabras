package com.servidores.JuegoPalabras.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43876691007560211L;
    public EquipoNotFoundException(String equipo) {
        super("Equipo con nombre" + equipo + " no existe");
    }
    public EquipoNotFoundException(Integer id) {super("Equipo con id " + id + " no existe");}
}
