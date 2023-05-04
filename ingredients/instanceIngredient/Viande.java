package ingredients.instanceIngredient;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class Viande extends Ingredient {
    public Viande(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Viande(String nom, EtatIngredient etat, double qty){
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }
}
