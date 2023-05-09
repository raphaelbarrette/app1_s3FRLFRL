package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Fruit;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

/**
 * instancie object Fruit
 */
public class ConcreteCreatorFruit implements creatorIngredient {
    /**
     * cree object Fruit
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Fruit(nom,etat);
    }

    /**
     * Cree object Fruit
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return
     * @throws IngredientException
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Fruit(groupe,nom);
    }

}
