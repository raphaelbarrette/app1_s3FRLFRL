package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Legume;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorLegume implements creatorIngredient {
    /**
     *
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Legume(nom, etat);
    }

    /**
     *
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Legume(groupe,nom);
    }
}