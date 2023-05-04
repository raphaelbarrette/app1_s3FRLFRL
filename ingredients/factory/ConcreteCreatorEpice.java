package ingredients.factory;

import ingredients.instanceIngredient.Epice;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class ConcreteCreatorEpice implements creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat){
        return new Epice(nom, etat);
    }
}
