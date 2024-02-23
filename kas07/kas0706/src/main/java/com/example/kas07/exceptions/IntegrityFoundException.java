package com.example.kas07.exceptions;

public class IntegrityFoundException extends Exception{
    public IntegrityFoundException(String msg){
        super(msg);
    }
    
    IntegrityFoundException(){
        super(" No se puede borrar porque tiene referencias asociadas");
    }
}
