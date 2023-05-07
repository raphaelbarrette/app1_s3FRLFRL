package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

public class Fruit extends Ingredient {

    public Fruit(String nom, EtatIngredient etat) {
        setNom(nom);
        setEtat(etat);
    }
    public Fruit(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    public Fruit(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }

}