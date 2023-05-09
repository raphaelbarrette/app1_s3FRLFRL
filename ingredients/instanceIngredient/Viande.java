package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

/**
 * class Viande sous classe de ingredient
 */
public class Viande extends Ingredient {
    /**
     *
     * @param nom de la Viande
     * @param etat de la Viande
     */
    public Viande(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }

    /**
     *
     * @param nom de la Viande
     * @param etat de la Viande
     * @param qty de la Viande
     * @throws IngredientException
     */
    public Viande(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    /**
     *
     * @param groupeingredient de la Viande
     * @param nom de la Viande
     */
    public Viande(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
