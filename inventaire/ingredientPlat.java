package inventaire;
import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

public class ingredientPlat {
    // array of ingredients needed for a plate
    private ArrayList<Ingredient> recette;

    /**
     * cree ingredientPlat avec ArrayList vide
     */
    public ingredientPlat(){
        this.recette = new ArrayList<Ingredient>();
    }
    // constructor filling the list with a list of ingredients

    /**
     *
     * @param ingredients liste d'ingredients a ajouter a la recette
     */
    public ingredientPlat(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // constructor filling the list with an ArrayList

    /**
     *
     * @param ingredients ArrayList d'ingredients a ajouter a recette
     */
    public ingredientPlat(ArrayList<Ingredient> ingredients){
        this.recette = ingredients;
    }
    /**
     *
     * @return ArrayList of ingredients
     */
    public ArrayList<Ingredient> getRecette(){
        return recette;
    }
    // changes the ArrayList to another one
    /**
     *
     * @param recette ArrayList replacement for recette
     */
    public void setRecette(ArrayList<Ingredient> recette) {
        this.recette = recette;
    }
    // changes the ArrayList to a list

    /**
     *
     * @param ingredients liste d'ingredient pour remplacer la recette
     */
    public void setRecette(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // adds an ingredient to the ArrayList
    //adds the qty if the ingredient is already in the ArrayList
    /**
     *
     * @param ingredient a ajouter
     * @throws IngredientException
     */
    public void ajouter(Ingredient ingredient) throws IngredientException {
        boolean trouver = false;
        for (Ingredient ing : recette){
            if (ing.equals(ingredient)) {
                ing.set_Qty(ing.get_Qty() + ingredient.get_Qty());
                trouver = true;
            }
        }
        if (!trouver){
            recette.add(ingredient);
        }
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Recette : " + recette + "\n";
    }

}
