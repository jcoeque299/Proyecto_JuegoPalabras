package com.servidores.JuegoPalabras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Palabras {
        @Id
        @GeneratedValue
        Integer id;
        String palabra;
}