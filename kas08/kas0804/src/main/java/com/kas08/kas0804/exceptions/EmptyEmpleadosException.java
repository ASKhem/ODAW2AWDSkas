package com.kas08.kas0804.exceptions;

public class EmptyEmpleadosException extends RuntimeException {
    public EmptyEmpleadosException() {
        super("No hay empleados en el sistema");
    }
}