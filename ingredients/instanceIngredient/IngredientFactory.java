package ingredients.instanceIngredient;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.TypeIngredient;
import ingredients.instanceIngredient.groupeIngredient;

import java.util.HashMap;
import java.util.Map;

/**
 * class IngredientFactory pour la factory
 */
public class IngredientFactory {
    private Map<String, groupeIngredient> groupeIngredientMap = new HashMap<>();

    /**
     * constructeur de groupeIngredient avec typeIngredient et etatIngredient
     * @param typeIngredient de l'ingredient
     * @param etatIngredient etat de l'ingredient
     * @return le groupe de l'ingredient
     */
    public groupeIngredient getGroupeIngredient(TypeIngredient typeIngredient, EtatIngredient etatIngredient){
        String key= createCompositeKey(typeIngredient,etatIngredient.getEtat());
        groupeIngredient groupeIngredient= groupeIngredientMap.get(key);
        if(groupeIngredient==null){
            groupeIngredient = new groupeIngredient(typeIngredient,etatIngredient);
        }
        return groupeIngredient;

    }

    /**
     * retourne la CompositeKey cree
     * @param type type de l'ingredient
     * @param etat de l'ingredient
     * @return compositeKey de l'ingredient
     */
    public String createCompositeKey(TypeIngredient type, String etat){
        return type.toString()+"-"+etat;

    }
}
