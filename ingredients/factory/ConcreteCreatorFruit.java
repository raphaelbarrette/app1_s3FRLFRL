package ingredients.factory;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Fruit;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorFruit implements creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat) throws IngredientException {
        return new Fruit(nom,etat);
    }
    public static Ingredient creer(groupeIngredient groupe, String nom) throws IngredientException{
        return new Fruit(groupe,nom);
    }

}
