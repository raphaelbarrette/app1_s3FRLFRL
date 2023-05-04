package inventaire;

import ingredients.instanceIngredient.Ingredient;

import java.util.HashMap;
//singleton
public class Inventaire {
    private static Inventaire instance = null;

    // ArrayList filled with ingredients
    private HashMap<String, Ingredient> contenant;

    //private constructor for singleton
    private Inventaire(){
        contenant = new HashMap<>();
    }

    // method to call the constructor if an object of the class doesn't already exist
    public Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }
    // adding an ingredient if it's not already there
    // if already there add the qty

    public void ajouter(Ingredient[] ingredients){
        for (Ingredient ingredient : ingredients){
            ajouter(ingredient);
        }
    }
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

}
