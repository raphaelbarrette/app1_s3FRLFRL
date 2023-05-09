package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

public class Laitier extends Ingredient {
    /**
     *
     * @param nom du Laitier
     * @param etat du Laitier
     */
    public Laitier(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }

    /**
     *
     * @param nom du Laitier
     * @param etat du Laitier
     * @param qty du Laitier
     * @throws IngredientException
     */
    public Laitier(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    /**
     *
     * @param groupeingredient du Laitier
     * @param nom du Laitier
     */
    public Laitier(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
