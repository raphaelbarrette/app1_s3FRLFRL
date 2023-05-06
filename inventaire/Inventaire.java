package inventaire;

import ingredients.exceptions.IngredientException;
import ingredients.factory.*;
import ingredients.factory.IngredientFactory;
import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.Ingredient;
import ingredients.instanceIngredient.TypeIngredient;
import ingredients.instanceIngredient.groupeIngredient;

import java.util.HashMap;
//singleton
public class Inventaire {
    private static Inventaire instance = null;

    // ArrayList filled with ingredients

    private HashMap<String, Ingredient> contenant;
    private IngredientFactory ingredientFactory;

    //private constructor for singleton


    private Inventaire(){

        contenant = new HashMap<>();
        ingredientFactory= new IngredientFactory();
    }

    // method to call the constructor if an object of the class doesn't already exist
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }
    // adding an ingredient if it's not already there
    // if already there add the qty

    /**
     *
     * @param ingredients liste d'objet de classe Ingredient
     */

    public void ajouter(Ingredient[] ingredients){
        for (Ingredient ingredient : ingredients){
            ajouter(ingredient);
        }
    }

    /**
     *
     * @param ingredient objet de la classe Ingredient
     */
    public void ajouter(Ingredient ingredient)
    {
        if (contenant.containsKey(ingredient.getNom())){
            Ingredient i = contenant.get(ingredient.getNom());
            i.set_Qty(i.get_Qty() + ingredient.get_Qty());
            return;
        }
            contenant.put(ingredient.getNom(), ingredient);
    }

    // finding an ingredient in the ArrayList
    // if no ingredient returns null
    public void ajouter(TypeIngredient typeIngredient, EtatIngredient etat, String nom) throws IngredientException {
        groupeIngredient groupeIng= ingredientFactory.getGroupeIngredient(typeIngredient,etat);
        String typeIngredientString= typeIngredient.toString();
        switch(typeIngredientString) {
            case "FRUIT":
                Ingredient fruit = ConcreteCreatorFruit.creer(groupeIng, nom);
                if (contenant.containsKey(fruit.getNom())) {
                    Ingredient ingred = contenant.get(fruit.getNom());
                    ingred.set_Qty(ingred.get_Qty() + fruit.get_Qty());

                } else {
                    contenant.put(fruit.getNom(), fruit);
                }
                break;
            case "LEGUME":
                Ingredient legume = ConcreteCreatorLegume.creer(groupeIng, nom);
                if (contenant.containsKey(legume.getNom())) {
                    Ingredient ingred = contenant.get(legume.getNom());
                    ingred.set_Qty(ingred.get_Qty() + legume.get_Qty());

                } else {
                    contenant.put(legume.getNom(), legume);
                }
                break;
            case "VIANDE":
                Ingredient viande = ConcreteCreatorViande.creer(groupeIng, nom);
                if (contenant.containsKey(viande.getNom())) {
                    Ingredient ingred = contenant.get(viande.getNom());
                    ingred.set_Qty(ingred.get_Qty() + viande.get_Qty());

                } else {
                    contenant.put(viande.getNom(), viande);
                }
                break;
            case "LAITIER":
                Ingredient laitier = ConcreteCreatorLaitier.creer(groupeIng, nom);
                if (contenant.containsKey(laitier.getNom())) {
                    Ingredient ingred = contenant.get(laitier.getNom());
                    ingred.set_Qty(ingred.get_Qty() + laitier.get_Qty());

                } else {
                    contenant.put(laitier.getNom(), laitier);
                }
                break;
            case "EPICE":
                Ingredient epice = ConcreteCreatorEpice.creer(groupeIng, nom);
                if (contenant.containsKey(epice.getNom())) {
                    Ingredient ingred = contenant.get(epice.getNom());
                    ingred.set_Qty(ingred.get_Qty() + epice.get_Qty());

                } else {
                    contenant.put(epice.getNom(), epice);
                }
                break;
        }

    }
    /**
     *
     * @param i object ingredient
     * @return l'ingredient qui est ajouter
     */
    public Ingredient getIngredient(Ingredient i){
        return contenant.get(i.getNom());
    }
    // returns size of ArrayList
    public int getSize(){
        return contenant.size();
    }
    public double getIngredientQty(Ingredient ingredient){
        if (contenant.get(ingredient.getNom()) != null){
            return contenant.get(ingredient.getNom()).get_Qty();
        }
        else{
            return 0;
        }
    }
    public void consommerRecette(ingredientPlat recette, int quantite, double proportion){
        for (Ingredient ing : recette.getRecette()){
            Ingredient ingredientContenant = contenant.get(ing.getNom());

            double qtyRecette = ing.get_Qty() * quantite * proportion;
            double qtyInventaire = ingredientContenant.get_Qty();

            if (qtyInventaire < qtyRecette){
                //throw exception
            }
            ingredientContenant.set_Qty(qtyInventaire - qtyRecette);
        }
    }

    public void clearInventaire(){
        if (instance != null){
            contenant.clear();
            instance = null;
        }
    }
    public String toString(){
        return "Inventaire" + contenant;
    }
    public Inventaire returnInstance(){
        return instance;
    }
}
