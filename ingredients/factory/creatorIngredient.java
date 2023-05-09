
package ingredients.factory;
import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

/**
 * interface pour la factory qui cree les ingredients
 */
public interface creatorIngredient {
    /**
     *
     * @param nom de l'ingredient
     * @param etat de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException;

    /**
     *
     * @param groupe de l'ingredient
     * @param nom de l'ingredient
     * @return l'ingredient creer
     * @throws IngredientException if ingredient constructor throws exception
     */
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException {
        return null;
    }
}