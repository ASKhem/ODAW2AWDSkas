package kas1006a.kas10.kas0601.exceptions;

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
