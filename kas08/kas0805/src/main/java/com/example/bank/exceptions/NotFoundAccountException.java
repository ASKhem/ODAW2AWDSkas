package com.example.bank.exceptions;

public class NotFoundAccountException extends RuntimeException{
    public NotFoundAccountException() {
        super("La cuenta no existe");
    }
}
