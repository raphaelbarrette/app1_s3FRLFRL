package inventaire;

import ingredients.exceptions.IngredientException;
import ingredients.factory.*;
import ingredients.instanceIngredient.*;

import java.util.HashMap;

/**
 * class Inventaire qui gere les ingredients disponible pour consommer un recette
 * singleton
 */
public class Inventaire {
    private static Inventaire instance = null;

    // ArrayList filled with ingredients

    private HashMap<String, Ingredient> contenant;
    private IngredientFactory ingredientFactory;
    private int size = 0;
    /**
     * private constructor for singleton
     */
    private Inventaire(){

        contenant = new HashMap<>();
        ingredientFactory= new IngredientFactory();
    }

    // method to call the constructor if an object of the class doesn't already exist

    /**
     *
     * @return object inventaire
     */
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

    public void ajouter(Ingredient[] ingredients) throws IngredientException {
        if (ingredients == null){
            throw new IngredientException("impossible de rajouter ingredient null");
        }
        for (Ingredient ingredient : ingredients){
            ajouter(ingredient);
        }
    }

    /**
     *
     * @param ingredient objet de la classe Ingredient
     */
    public void ajouter(Ingredient ingredient) throws IngredientException {
        if (ingredient == null){
            throw new IngredientException("Impossible de rajouter ingredient null");
        }
        if (contenant.containsKey(ingredient.getNom())){
            Ingredient i = contenant.get(ingredient.getNom());
            i.set_Qty(i.get_Qty() + ingredient.get_Qty());
            return;
        }
            contenant.put(ingredient.getNom(), ingredient);
            size++;
    }

    // finding an ingredient in the ArrayList
    // if no ingredient returns null

    /**
     *
     * @param typeIngredient de l'ingredient a ajouter
     * @param etat de l'ingredient
     * @param nom de l'ingredient
     * @throws IngredientException
     */
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
                    size++;
                }
                break;
            case "LEGUME":
                Ingredient legume = ConcreteCreatorLegume.creer(groupeIng, nom);
                if (contenant.containsKey(legume.getNom())) {
                    Ingredient ingred = contenant.get(legume.getNom());
                    ingred.set_Qty(ingred.get_Qty() + legume.get_Qty());

                } else {
                    contenant.put(legume.getNom(), legume);
                    size++;
                }
                break;
            case "VIANDE":
                Ingredient viande = ConcreteCreatorViande.creer(groupeIng, nom);
                if (contenant.containsKey(viande.getNom())) {
                    Ingredient ingred = contenant.get(viande.getNom());
                    ingred.set_Qty(ingred.get_Qty() + viande.get_Qty());

                } else {
                    contenant.put(viande.getNom(), viande);
                    size++;
                }
                break;
            case "LAITIER":
                Ingredient laitier = ConcreteCreatorLaitier.creer(groupeIng, nom);
                if (contenant.containsKey(laitier.getNom())) {
                    Ingredient ingred = contenant.get(laitier.getNom());
                    ingred.set_Qty(ingred.get_Qty() + laitier.get_Qty());

                } else {
                    contenant.put(laitier.getNom(), laitier);
                    size++;
                }
                break;
            case "EPICE":
                Ingredient epice = ConcreteCreatorEpice.creer(groupeIng, nom);
                if (contenant.containsKey(epice.getNom())) {
                    Ingredient ingred = contenant.get(epice.getNom());
                    ingred.set_Qty(ingred.get_Qty() + epice.get_Qty());

                } else {
                    contenant.put(epice.getNom(), epice);
                    size++;
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

    /**
     *
     * @return taille de l'inventaire
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @param ingredient a retourner sa quantite
     * @return quantite de l'ingredient
     */
    public double getIngredientQty(Ingredient ingredient){
        if (contenant.get(ingredient.getNom()) != null){
            return contenant.get(ingredient.getNom()).get_Qty();
        }
        else{
            return 0;
        }
    }

    /**
     *
     * @param recette d'ingredient a consommer dans l'inventaire
     * @param quantite de recette
     * @param proportion proportion de la recette
     * @throws IngredientException
     */
    public void consommerRecette(ingredientPlat recette, int quantite, double proportion) throws IngredientException {
        for (Ingredient ing : recette.getRecette()){
            Ingredient ingredientContenant = contenant.get(ing.getNom());

            double qtyRecette = ing.get_Qty() * quantite * proportion;
            double qtyInventaire = ingredientContenant.get_Qty();

            if (qtyInventaire < qtyRecette){
                throw new IngredientException("Pas asser d'ingredient");
            }
            ingredientContenant.set_Qty(qtyInventaire - qtyRecette);
        }
    }

    /**
     * vide l'inventaire et rends l'object null
     */
    public void clearInventaire(){
        if (instance != null){
            contenant.clear();
            instance = null;
            size = 0;
        }
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Inventaire" + contenant;
    }

    /**
     *
     * @return l'object inventaire
     */
    public Inventaire returnInstance(){
        return instance;
    }





}
