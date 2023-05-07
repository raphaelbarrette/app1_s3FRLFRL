package menufact.plats.exceptions;

public class PlatException extends Throwable{
    public PlatException(String error){
        super("PlatExcpetion : " + error);
    }
}
