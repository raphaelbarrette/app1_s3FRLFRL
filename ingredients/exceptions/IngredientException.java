package ingredients.exceptions;

/**
 * excpetion pour les ingredients
 */
public class IngredientException extends Exception{
    /**
     *
     * @param message a afficher pour l'excpetion
     */
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
