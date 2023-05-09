package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;

public class EtatLiquide implements EtatIngredient {
    private double qtyL;
    private String etat="liquide";

    /**
     *
     * @param qty quantite de l'ingredient
     * @throws IngredientException
     */
    public EtatLiquide(double qty) throws IngredientException {
        set_Qty(qty);
    }

    /**
     *
     * @return quantite de l'ingredient
     */
    public double get_Qty(){
        return qtyL;
    }

    /**
     *
     * @return etat de l'ingredient
     */
    public String getEtat(){
        return etat;
    }

    /**
     *
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
     *
     * @return String a afficher
     */
    public String toString(){
        return "Liquide, Quantite : " + this.get_Qty() + "\n";
    }

    /**
     *
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
     *
     * @param other ingredient a ajouter la quantite
     */
    public void addQty(Object other){
        if (other instanceof EtatLiquide){
            this.qtyL = this.qtyL + ((EtatLiquide) other).get_Qty();
        }
    }

}