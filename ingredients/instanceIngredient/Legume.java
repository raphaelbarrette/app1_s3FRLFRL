package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class Legume extends Ingredient {
    public Legume(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Legume(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }
    public Legume(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
