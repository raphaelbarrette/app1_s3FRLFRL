package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;

/**
 * class Legume sous classe de Ingredient
 */
public class Legume extends Ingredient {
    /**
     * constructeur de Legume avec le nom et l'etat
     * @param nom du Legume
     * @param etat du Legume
     */
    public Legume(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }

    /**
     * constructeur de Legume avec le nom, l'etat et la quantite
     * @param nom du Legume
     * @param etat du Legume
     * @param qty du Legume
     * @throws IngredientException
     */
    public Legume(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    /**
     * constructeur de Legume avec le groupeingredient et le nom
     * @param groupeingredient du Legume
     * @param nom du Legume
     */
    public Legume(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}
