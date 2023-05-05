package menufact.plats;
import ingredients.instanceIngredient.Ingredient;
import inventaire.ingredientPlat;

public class BuilderPlat {
    protected PlatAuMenu plat;
    public BuilderPlat(){
        plat = new PlatAuMenu();
    }
    public PlatAuMenu getPlat(){
        return plat;
    }
    public void clear(){
        plat = new PlatAuMenu();
    }
    public void build_description(String description){
        plat.setDescription(description);
    }

    public void build_prix(double prix){
        plat.setPrix(prix);
    }
    public void build_recette(ingredientPlat recette){
        plat.setRecette(recette);
    }
    public void buid_recette(Ingredient[] ingredients){
        plat.setRecette(new ingredientPlat(ingredients));
    }
}
