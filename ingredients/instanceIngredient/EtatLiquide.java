package ingredients.instanceIngredient;

import ingredients.instanceIngredient.EtatIngredient;

public class EtatLiquide implements EtatIngredient {
    private double qtyL;
    public EtatLiquide(double qty){
        set_Qty(qty);
    }
    public double get_Qty(){
        return qtyL;
    }
    public void set_Qty(double qty){
        this.qtyL = qty;
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
