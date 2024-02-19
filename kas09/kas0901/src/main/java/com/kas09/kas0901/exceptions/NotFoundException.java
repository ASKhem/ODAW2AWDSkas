package com.kas09.kas0901.exceptions;

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
