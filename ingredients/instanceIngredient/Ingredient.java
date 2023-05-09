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

    /**
     * constructeur d'ingredient
     */
    public Ingredient(){}

    /**
     * retourne le nom de l'ingredient
     * @return nom de l'ingredient
     */
    public String getNom() {
        return nom;
    }

    /**
     * set le nom de l'ingredient
     * @param nom de l'ingredient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * retourne l'etat de l'ingredient
     * @return etat de l'ingredient
     */
    public EtatIngredient getEtat(){
        return etatIngredient;
    }

    /**
     * set l'etat de l'ingredient
     * @param etatIngredient etat de l'ingredient
     */
    public void setEtat(EtatIngredient etatIngredient){
        this.etatIngredient = etatIngredient;
    }

    /**
     * retourne la quantite de l'ingredient
     * @return qunatite de l'ingredient
     */
    public double get_Qty(){
        return etatIngredient.get_Qty();
    }

    /**
     * set la quantite de l'ingredient
     * @param qty quantite de l'ingredient
     * @throws IngredientException
     */
    public void set_Qty(double qty) throws IngredientException {
        etatIngredient.set_Qty(qty);
    }

    /**
     * retourne String de l'ingredient
     * @return String a afficher
     */
    public String toString(){
        return "Ingredient : " + this.getNom() + " Etat: " + etatIngredient;
    }

    /**
     * verifie si un object Ingredient est egal a un autre
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
     * retourn le groupe de l'ingredient
     * @return groupe de l'ingredient
     */
    public groupeIngredient getGroupe(){
        return groupe;
    }
}