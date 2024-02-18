package com.example.bank.exceptions;

public class AmountOutOfRangeException extends RuntimeException{
    public AmountOutOfRangeException(double cantidad) {
        super("La cantidad " + cantidad + " no es válida");
    }
}
