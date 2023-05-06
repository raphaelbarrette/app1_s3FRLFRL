package ingredients.factory;

import ingredients.instanceIngredient.EtatIngredient;
import ingredients.instanceIngredient.TypeIngredient;
import ingredients.instanceIngredient.groupeIngredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientFactory {
    private Map<String, groupeIngredient> groupeIngredientMap = new HashMap<>();
    public groupeIngredient getGroupeIngredient(TypeIngredient typeIngredient, EtatIngredient etatIngredient){
        String key= createCompositeKey(typeIngredient,etatIngredient.getEtat());
        groupeIngredient groupeIngredient= groupeIngredientMap.get(key);
        if(groupeIngredient==null){
            groupeIngredient = new groupeIngredient(typeIngredient,etatIngredient);
        }
        return groupeIngredient;

    }

    public String createCompositeKey(TypeIngredient type, String etat){
        return type.toString()+"-"+etat;

    }
}
