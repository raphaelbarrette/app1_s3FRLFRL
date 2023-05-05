package ingredients.instanceIngredient;

public class groupeIngredient {
    //type de l<ingredient aka fruit, legume, etc.
    private TypeIngredient type;
    //etat de l ingredient pour savoir liquide ou solide
    private EtatIngredient etat;

    public groupeIngredient(TypeIngredient typeIngredient, EtatIngredient etatIngredient){
        this.type=typeIngredient;
        this.etat=etatIngredient;
    }

    public EtatIngredient getEtat(){
        return etat;
    }

    public TypeIngredient getType(){
        return type;
    }
}
