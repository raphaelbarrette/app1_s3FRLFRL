package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

/**
 * class Laitier sous classe de Ingredient
 */
public class Laitier extends Ingredient {
    /**
     * constructeur de Laitier avec le nom et l'etat
     * @param nom du Laitier
     * @param etat du Laitier
     */
    public Laitier(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }

    /**
     * constructeur de Laitier avec le nom, l'etat et la quantite
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
     * constructeur de Laitier avec le groupeingredient et le nom
     * @param groupeingredient du Laitier
     * @param nom du Laitier
     */
    public Laitier(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
