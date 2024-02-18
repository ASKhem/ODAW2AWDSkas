package com.kas08.kas0807.exceptions;

public class GenericNotFoundException extends RuntimeException {
    public GenericNotFoundException() {
        super("No se encontró el recurso solicitado");
    }
}
