package com.example.bank.exceptions;

public class EmptyAccountsListException extends RuntimeException{
    public EmptyAccountsListException() {
        super("No hay cuentas existentes");
    }
}
