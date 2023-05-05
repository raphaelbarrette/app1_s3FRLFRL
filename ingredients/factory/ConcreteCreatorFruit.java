package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Fruit;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.groupeIngredient;

public class ConcreteCreatorFruit implements creatorIngredient {
    public Ingredient creer(String nom,EtatIngredient etat){
        return new Fruit(nom,etat);
    }
    public static Ingredient creer(groupeIngredient groupe, String nom, double quantite){
        return new Fruit(groupe,nom,quantite);
    }

}
