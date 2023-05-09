package menufact.plats;
import ingredients.instanceIngredient.Ingredient;
import inventaire.ingredientPlat;

/**
 * class BuilderPlat pour le builder des plats
 */
public class BuilderPlat {
    protected PlatAuMenu plat;

    /**
     * constructor of platBuilder
     */
    public BuilderPlat(){
        plat = new PlatAuMenu();
    }

    /**
     * retourne plat
     * @return PlatAuMenu
     */
    public PlatAuMenu getPlat(){
        return plat;
    }

    /**
     * remplace le plat par un nouveau null
     */
    public void clear(){
        plat = new PlatAuMenu();
    }

    /**
     * set la description d'un plat
     * @param description du plat a build
     */
    public void build_description(String description){
        plat.setDescription(description);
    }

    /**
     * set le prix d'un plat
     * @param prix du plat a build
     */
    public void build_prix(double prix){
        plat.setPrix(prix);
    }

    /**
     * set la recette d'un plat
     * @param recette du plat a build
     */
    public void build_recette(ingredientPlat recette){
        plat.setRecette(recette);
    }

    /**
     * cree et set la recette d'un plat avec un liste d'ingredient
     * @param ingredients liste d'ingredient a ajouter dans la recette
     */
    public void buid_recette(Ingredient[] ingredients){
        plat.setRecette(new ingredientPlat(ingredients));
    }
}
