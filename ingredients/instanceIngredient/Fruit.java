package ingredients.instanceIngredient;

public class Fruit extends Ingredient {

    public Fruit(String nom, EtatIngredient etat) {
        setNom(nom);
        setEtat(etat);
    }
    public Fruit(String nom, EtatIngredient etat, double qty){
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

}
