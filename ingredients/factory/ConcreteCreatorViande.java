package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Viande;
import ingredients.instanceIngredient.groupeIngredient;

/**
 * instancie object Viande
 */
public class ConcreteCreatorViande implements creatorIngredient {
    /**
     * cree object Viande
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Viande(nom,etat);
    }

    /**
     * cree object Viande
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Viande(groupe,nom);
    }
}