package com.example.bank.exceptions;

public class NotEmptyMovementsAccount extends RuntimeException{
    public NotEmptyMovementsAccount() {
        super("La cuenta no se puede eliminar porque tiene movimientos asociados");
    }
}
