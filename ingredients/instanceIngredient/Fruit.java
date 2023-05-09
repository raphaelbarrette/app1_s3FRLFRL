package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

/**
 * class Fruit sous class de Ingredient
 */
public class Fruit extends Ingredient {
    /**
     *
     * @param nom du Fruit
     * @param etat du Fruit
     */
    public Fruit(String nom, EtatIngredient etat) {
        setNom(nom);
        setEtat(etat);
    }

    /**
     *
     * @param nom du Fruit
     * @param etat du Fruit
     * @param qty du Fruit
     * @throws IngredientException
     */
    public Fruit(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    /**
     *
     * @param groupeingredient du Fruit
     * @param nom du Fruit
     */
    public Fruit(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }

}