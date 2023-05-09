package inventaire;
import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * class ingredientPlat qui gere la recette d'ingredient necessite pour un plat
 */
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
     * constructeur de ingredientPlat avec une liste d'ingredients
     * @param ingredients liste d'ingredients a ajouter a la recette
     */
    public ingredientPlat(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // constructor filling the list with an ArrayList

    /**
     * constructeur de ingredientPlat avec une ArrayList d'ingredients
     * @param ingredients ArrayList d'ingredients a ajouter a recette
     */
    public ingredientPlat(ArrayList<Ingredient> ingredients){
        this.recette = ingredients;
    }
    /**
     * retourne l'ArrayList recette
     * @return ArrayList of ingredients
     */
    public ArrayList<Ingredient> getRecette(){
        return recette;
    }
    // changes the ArrayList to another one
    /**
     * set la recette avec une ArrayList d'ingredient
     * @param recette ArrayList replacement for recette
     */
    public void setRecette(ArrayList<Ingredient> recette) {
        this.recette = recette;
    }
    // changes the ArrayList to a list

    /**
     * set la recette avec une liste d'ingredient
     * @param ingredients liste d'ingredient pour remplacer la recette
     */
    public void setRecette(Ingredient[] ingredients){
        this.recette = new ArrayList<>(Arrays.asList(ingredients));
    }
    // adds an ingredient to the ArrayList
    //adds the qty if the ingredient is already in the ArrayList
    /**
     * ajoute un ingredient a l'ArrayList recette
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
     * retourne String de l'object ingredientPlat
     * @return String a afficher
     */
    public String toString(){
        return "Recette : " + recette + "\n";
    }

}
