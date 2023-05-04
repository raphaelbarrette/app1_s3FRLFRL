package ingredients.instanceIngredient;

import ingredients.instanceIngredient.EtatIngredient;

//abstract for bridge
public abstract class Ingredient {
    private String nom;
    protected EtatIngredient etatIngredient;

    public Ingredient(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public EtatIngredient getEtat(){
        return etatIngredient;
    }
    public void setEtat(EtatIngredient etatIngredient){
        this.etatIngredient = etatIngredient;
    }
    public double get_Qty(){
        return etatIngredient.get_Qty();
    }
    public void set_Qty(double qty){
        etatIngredient.set_Qty(qty);
    }
    public String toString(){
        return "Ingredient : " + this.getNom() + " Etat :   " + etatIngredient + "\n";
    }
    public boolean equals(Object other){
        if (other == this){
            return true;
        }
        if (other instanceof Ingredient){
            return nom.equals(((Ingredient) other).getNom());
        }
        return false;
    }

    public void addQty(Ingredient i){

    }

}