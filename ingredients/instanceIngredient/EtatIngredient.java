package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

/**
 * interface pour les Etat d'Ingredient
 */
public interface EtatIngredient
{
    /**
     *
     * @return quantite de l'ingredient
     */
    public double get_Qty();

    /**
     *
     * @param qty a set a l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException;

    /**
     *
     * @param other ingredient a ajouter la quantite
     */
    public void addQty(Object other);

    /**
     *
     * @param other object a comparer l'egalite
     * @return
     */
    public boolean equals(Object other);

    /**
     *
     * @return etat de l'ingredient
     */
    public String getEtat();

    /**
     *
     * @return String a afficher
     */
    public String toString();

}