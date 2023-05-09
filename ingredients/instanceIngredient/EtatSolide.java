package ingredients.instanceIngredient;
import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;

/**
 * class EtatSolide qui utilise EtatIngredient
 */
public class EtatSolide implements EtatIngredient {
    private double qtykg;
    private String etat="Solide";

    /**
     *
     * @param qty de l'ingredient
     * @throws IngredientException
     */
    public EtatSolide(double qty) throws IngredientException {
        set_Qty(qty);
    }

    /**
     *
     * @param qty a set a l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException {
        if (qty >= 0) {
            qtykg = qty;
        } else {
            throw new IngredientException("quantite negative");
        }
    }

    /**
     *
     * @return quantite de l'ingredient
     */
    public double get_Qty(){
        return qtykg;
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Solide, Quantite : " + this.get_Qty() + "\n";
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
     * @param other object a comparer l'egalite
     * @return vrai si egal, faux sinon
     */
    public boolean equals(Object other){
        if (other == this){
            return true;
        }
        if(other instanceof EtatSolide){
            return this.get_Qty() == ((EtatSolide) other).get_Qty();
        }
        return false;
    }

    /**
     *
     * @param other ingredient a ajouter la quantite
     */
    public void addQty(Object other){
        if(other instanceof EtatSolide){
            this.qtykg = this.qtykg + ((EtatSolide) other).get_Qty();
        }
    }
}