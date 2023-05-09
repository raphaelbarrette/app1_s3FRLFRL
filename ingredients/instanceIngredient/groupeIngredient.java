package ingredients.instanceIngredient;

public class groupeIngredient {
    //type de l<ingredient aka fruit, legume, etc.
    private TypeIngredient type;
    //etat de l ingredient pour savoir liquide ou solide
    private EtatIngredient etat;

    /**
     *
     * @param typeIngredient du groupeIngredient
     * @param etatIngredient du groupeIngredient
     */
    public groupeIngredient(TypeIngredient typeIngredient, EtatIngredient etatIngredient){
        this.type=typeIngredient;
        this.etat=etatIngredient;
    }

    /**
     *
     * @return etat de l'ingredient
     */
    public EtatIngredient getEtat(){
        return etat;
    }

    /**
     *
     * @return type de l'ingredient
     */
    public TypeIngredient getType(){
        return type;
    }
}
