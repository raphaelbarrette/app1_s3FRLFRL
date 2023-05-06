package ingredients.instanceIngredient;

public class Epice extends Ingredient
{
    public Epice(String nom, EtatIngredient etat){
        setNom(nom);
        setEtat(etat);
    }
    public Epice(String nom, EtatIngredient etat, double qty){
        setNom(nom);
        setEtat(etat);
        set_Qty(qty);
    }

    public Epice(groupeIngredient groupeingredient, String nom){
        this.groupe=groupeingredient;
        this.nom=nom;
        this.setEtat(groupeingredient.getEtat());

    }
}