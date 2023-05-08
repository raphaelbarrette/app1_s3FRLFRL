package inventaire;
import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

public class ingredientPlat {
    // array of ingredients needed for a plate
    private ArrayList<Ingredient> recette;
    public ingredientPlat(){
        this.recette = new ArrayList<Ingredient>();
    }
    // constructor filling the list with a list of ingredients
    public ingredientPlat(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // constructor filling the list with an ArrayList
    public ingredientPlat(ArrayList<Ingredient> ingredients){
        this.recette = ingredients;
    }
    // returns the ArrayList of ingredients
    public ArrayList<Ingredient> getRecette(){
        return recette;
    }
    // changes the ArrayList to another one
    public void setRecette(ArrayList<Ingredient> recette) {
        this.recette = recette;
    }
    // changes the ArrayList to a list
    public void setRecette(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // adds an ingredient to the ArrayList
    //adds the qty if the ingredient is already in the ArrayList
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
    public String toString(){
        return "Recette : " + recette + "\n";
    }

}
