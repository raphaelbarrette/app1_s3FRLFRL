package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Laitier;

public class ConcreteCreatorLaitier implements creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat){
        return new Laitier(nom, etat);
    }
}
