package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Fruit;
import ingredients.instanceIngredient.Ingredient;

public class ConcreteCreatorFruit implements creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat){
        return new Fruit(nom, etat);
    }

}
