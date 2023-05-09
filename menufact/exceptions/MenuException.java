package menufact.exceptions;

public class MenuException extends Exception{
    /**
     *
     * @param message pour l'exception
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

