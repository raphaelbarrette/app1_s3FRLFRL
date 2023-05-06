package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Epice;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorEpice implements creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Epice(nom,etat);
    }
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Epice(groupe,nom);
    }
}