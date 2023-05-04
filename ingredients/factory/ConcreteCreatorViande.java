package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Viande;

public class ConcreteCreatorViande implements creatorIngredient {
    public Ingredient creer(String nom, EtatIngredient etat){
        return new Viande(nom, etat);
    }
}
