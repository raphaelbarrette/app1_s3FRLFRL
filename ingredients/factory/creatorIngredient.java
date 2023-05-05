
package ingredients.factory;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;


public interface creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat);

    public static Ingredient creer(groupeIngredient groupe, String nom, double quantite) {
        return null;
    }
}