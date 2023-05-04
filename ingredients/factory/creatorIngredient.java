package ingredients.factory;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;



public interface creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat);
}
