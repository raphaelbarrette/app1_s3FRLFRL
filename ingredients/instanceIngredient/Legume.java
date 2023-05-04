package ingredients.instanceIngredient;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class Legume extends Ingredient {
    public Legume(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Legume(String nom, EtatIngredient etat, double qty){
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }
}
