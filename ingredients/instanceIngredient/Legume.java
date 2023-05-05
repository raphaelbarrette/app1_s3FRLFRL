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
    public Legume(groupeIngredient groupeingredient, String nom,double qty){
        groupeingredient.getEtat().set_Qty(qty);
        this.groupe=groupeingredient;
        this.nom=nom;

    }
}
