package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

/**
 * class Epice sous class Ingredient
 */
public class Epice extends Ingredient
{
    /**
     * constructeur epice avec nom et etat
     * @param nom de l'Epice
     * @param etat de l'epice
     */
    public Epice(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }

    /**
     * constructeur epice avec nom, etat et quantite
     * @param nom de l'Epice
     * @param etat de l'Epice
     * @param qty de l'Epice
     * @throws IngredientException
     */
    public Epice(String nom, EtatIngredient etat, double qty) throws IngredientException {
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    /**
     * constructeur epice avec groupeingredient et nom
     * @param groupeingredient de l'Epice
     * @param nom de l'Epice
     */
    public Epice(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}