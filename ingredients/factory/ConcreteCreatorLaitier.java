package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Laitier;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorLaitier implements creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Laitier(nom,etat);
    }
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Laitier(groupe,nom);
    }
}
