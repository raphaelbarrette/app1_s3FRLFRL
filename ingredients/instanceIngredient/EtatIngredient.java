package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

/**
 * interface pour les Etat d'Ingredient
 */
public interface EtatIngredient
{
    /**
     * retourne quantite de l'ingredient
     * @return quantite de l'ingredient
     */
    public double get_Qty();

    /**
     * set la quantite de l'ingredient
     * @param qty a set a l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException;

    /**
     * ajoute des quantites d'ingredients
     * @param other ingredient a ajouter la quantite
     */
    public void addQty(Object other);

    /**
     * verifie si un object ingredient est egale a un autre
     * @param other object a comparer l'egalite
     * @return
     */
    public boolean equals(Object other);

    /**
     * retourne l'etat de l'ingredient
     * @return etat de l'ingredient
     */
    public String getEtat();

    /**
     * retourne String de l'ingredient
     * @return String a afficher
     */
    public String toString();

}