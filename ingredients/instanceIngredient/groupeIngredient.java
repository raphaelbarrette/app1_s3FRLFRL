package ingredients.instanceIngredient;

/**
 * class groupeIngredient regroupe type de l'ingredient et l'etat de l'ingredient
 */
public class groupeIngredient {
    //type de l<ingredient aka fruit, legume, etc.
    private TypeIngredient type;
    //etat de l ingredient pour savoir liquide ou solide
    private EtatIngredient etat;

    /**
     * constructeur de groupeIngredient avec typeIngredient et etatIngredient
     * @param typeIngredient du groupeIngredient
     * @param etatIngredient du groupeIngredient
     */
    public groupeIngredient(TypeIngredient typeIngredient, EtatIngredient etatIngredient){
        this.type=typeIngredient;
        this.etat=etatIngredient;
    }

    /**
     * retourne l'etat de l'ingredient
     * @return etat de l'ingredient
     */
    public EtatIngredient getEtat(){
        return etat;
    }

    /**
     * retourne type de l'ingredient
     * @return type de l'ingredient
     */
    public TypeIngredient getType(){
        return type;
    }
}
