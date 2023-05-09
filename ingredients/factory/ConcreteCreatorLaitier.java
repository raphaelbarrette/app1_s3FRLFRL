package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Laitier;
import ingredients.instanceIngredient.groupeIngredient;

/**
 * instancie object Laitier
 */
public class ConcreteCreatorLaitier implements creatorIngredient {
    /**
     * cree object Laitier
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Laitier(nom,etat);
    }

    /**
     * cree object Laitier
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return l'ingredient
     * @throws IngredientException if ingredient constructor throw exception
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Laitier(groupe,nom);
    }
}
