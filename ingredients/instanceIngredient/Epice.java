package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

public class Epice extends Ingredient
{
    public Epice(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Epice(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    public Epice(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}