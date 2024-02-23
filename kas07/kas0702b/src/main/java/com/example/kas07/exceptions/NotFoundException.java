package com.example.kas07.exceptions;

public class NotFoundException extends Exception{
    //Opción 1
    public NotFoundException(String msg){
        super(msg);
    }
    //Opcion 2
    NotFoundException(){
        super("Elemento no encontrado");
    }
}
