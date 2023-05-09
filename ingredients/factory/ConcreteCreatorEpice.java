package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Epice;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

/**
 * instancie un object Epice
 */
public class ConcreteCreatorEpice implements creatorIngredient {
    /**
     *
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return ingredient creer
     * @throws IngredientException if constructor of ingredient throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Epice(nom,etat);
    }

    /**
     *
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return l'ingredient
     * @throws IngredientException if constructor of ingrdient throw exception
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Epice(groupe,nom);
    }
}