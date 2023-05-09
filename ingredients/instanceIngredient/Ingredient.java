package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.EtatIngredient;

/**
 * abstract pour le bridge
 */
public abstract class Ingredient {
    protected String nom;
    protected EtatIngredient etatIngredient;
    protected groupeIngredient groupe;

    public Ingredient(){}

    /**
     *
     * @return nom de l'ingredient
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom de l'ingredient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return etat de l'ingredient
     */
    public EtatIngredient getEtat(){
        return etatIngredient;
    }

    /**
     *
     * @param etatIngredient etat de l'ingredient
     */
    public void setEtat(EtatIngredient etatIngredient){
        this.etatIngredient = etatIngredient;
    }

    /**
     *
     * @return qunatite de l'ingredient
     */
    public double get_Qty(){
        return etatIngredient.get_Qty();
    }

    /**
     *
     * @param qty quantite de l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException {
        etatIngredient.set_Qty(qty);
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Ingredient : " + this.getNom() + " Etat: " + etatIngredient;
    }

    /**
     *
     * @param other ingredient a comparer
     * @return true si egal, faux sinon
     */
    public boolean equals(Object other){
        if (other == this){
            return true;
        }
        if (other instanceof Ingredient){
            return nom.equals(((Ingredient) other).getNom());
        }
        return false;
    }

    /**
     *
     * @return groupe de l'ingredient
     */
    public groupeIngredient getGroupe(){
        return groupe;
    }
}