package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Legume;

public class ConcreteCreatorLegume implements creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat){
        return new Legume(nom, etat);
    }
}
