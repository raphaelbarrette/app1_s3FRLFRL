package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.Legume;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorLegume implements creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat){
        return new Legume(nom, etat);
    }
    public static Ingredient creer(groupeIngredient groupe, String nom, double quantite){
        return new Legume(groupe,nom,quantite);
    }
}