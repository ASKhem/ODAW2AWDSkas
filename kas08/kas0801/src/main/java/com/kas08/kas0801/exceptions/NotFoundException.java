package com.kas08.kas0801.exceptions;

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