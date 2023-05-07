package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class Viande extends Ingredient {
    public Viande(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Viande(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }
    public Viande(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
