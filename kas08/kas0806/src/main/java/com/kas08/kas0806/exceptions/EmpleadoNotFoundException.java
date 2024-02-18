package com.kas08.kas0806.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(Long id) {
        super("No se puede encontrar empleado con ID: " + id);
    }
}
