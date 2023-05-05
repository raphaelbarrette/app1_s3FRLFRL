package ingredients.instanceIngredient;
import ingredients.instanceIngredient.EtatIngredient;

public class EtatSolide implements EtatIngredient {
    private double qtykg;
    private String etat="Solide";
    public EtatSolide(double qty){
        set_Qty(qty);
    }
    public void set_Qty(double qty) {
        qtykg = qty;
    }
    public double get_Qty(){
        return qtykg;
    }
    public String toString(){
        return "Solide, Quantite : " + this.get_Qty() + "\n";
    }
    public String getEtat(){
        return etat;
    }

    public boolean equals(Object other){
        if (other == this){
            return true;
        }
        if(other instanceof EtatSolide){
            return this.get_Qty() == ((EtatSolide) other).get_Qty();
        }
        return false;
    }
    public void addQty(Object other){
        if(other instanceof EtatSolide){
            this.qtykg = this.qtykg + ((EtatSolide) other).get_Qty();
        }
    }
}