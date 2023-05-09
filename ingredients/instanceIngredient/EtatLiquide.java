package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;

/**
 * class EtatLiquide utilise l'interface EtatIngredient
 */
public class EtatLiquide implements EtatIngredient {
    private double qtyL;
    private String etat="liquide";

    /**
     * constructeur de l'etat liquide avec quantite
     * @param qty quantite de l'ingredient
     * @throws IngredientException
     */
    public EtatLiquide(double qty) throws IngredientException {
        set_Qty(qty);
    }

    /**
     * retourne quantite de l'ingredient
     * @return quantite de l'ingredient
     */
    public double get_Qty(){
        return qtyL;
    }

    /**
     * retourne l'etat de l'ingredient
     * @return etat de l'ingredient
     */
    public String getEtat(){
        return etat;
    }

    /**
     * set la quantite de l'ingredient
     * @param qty a set a l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException {
        if (qty >= 0) {
            this.qtyL = qty;
        } else {
            throw new IngredientException("quantite negative");
        }
    }

    /**
     *  retourne String de l'ingredient
     * @return String a afficher
     */
    public String toString(){
        return "Liquide, Quantite : " + this.get_Qty() + "\n";
    }

    /**
     * verifie si un object EtatLiquide est egal a un autre
     * @param other object a comparer l'egalite
     * @return true si egal, false si faux
     */
    public boolean equals(Object other){
        if(other == this){
            return true;
        }
        if (other instanceof EtatLiquide){
            return this.get_Qty() == ((EtatLiquide) other).get_Qty();

        }
        return false;
    }

    /**
     * ajoute un object EtatLiquide a un autre
     * @param other ingredient a ajouter la quantite
     */
    public void addQty(Object other){
        if (other instanceof EtatLiquide){
            this.qtyL = this.qtyL + ((EtatLiquide) other).get_Qty();
        }
    }

}