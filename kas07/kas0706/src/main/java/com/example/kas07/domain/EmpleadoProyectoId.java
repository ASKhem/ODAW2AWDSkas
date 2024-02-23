package com.example.kas07.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public class EmpleadoProyectoId implements Serializable {
    private Long empleado;
    private Long proyecto;
}
