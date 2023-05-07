package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;

public class EtatLiquide implements EtatIngredient {
    private double qtyL;
    private String etat="liquide";
    public EtatLiquide(double qty) throws IngredientException {
        set_Qty(qty);
    }
    public double get_Qty(){
        return qtyL;
    }
    public String getEtat(){
        return etat;
    }

    public void set_Qty(double qty) throws IngredientException {
        if (qty >= 0) {
            this.qtyL = qty;
        } else {
            throw new IngredientException("quantite negative");
        }
    }

    public String toString(){
        return "Liquide, Quantite : " + this.get_Qty() + "\n";
    }

    public boolean equals(Object other){
        if(other == this){
            return true;
        }
        if (other instanceof EtatLiquide){
            return this.get_Qty() == ((EtatLiquide) other).get_Qty();

        }
        return false;
    }

    public void addQty(Object other){
        if (other instanceof EtatLiquide){
            this.qtyL = this.qtyL + ((EtatLiquide) other).get_Qty();
        }
    }

}