package menufact;

import ingredients.instanceIngredient.Ingredient;
import inventaire.Inventaire;
import menufact.plats.PlatChoisi;
import menufact.plats.etatPlat.*;
import inventaire.ingredientPlat;


public class chef {
    private chef instance = null;
    private String nom;
    private chef(){}
    public chef getInstance(){
        if (instance == null){
            instance = new chef();
        }
        return instance;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        if(nom == null) {
            this.nom = nom;
        }
    }
    public String toString(){
        return "Chef : " + nom + "\n";
    }
    private void preparer(PlatChoisi platapreparer){
        platapreparer.setEtat(new Preparation());

        Inventaire inventaire = Inventaire.getInstance();
        ingredientPlat recette = platapreparer.getPlat().getRecette();

        inventaire.consommerRecette(recette, platapreparer.getQuantite(), platapreparer.getPlat().getProportion());

    }

    private boolean verifierIngredient(PlatChoisi plat){
        Inventaire inventaire = Inventaire.getInstance();
        ingredientPlat recette = plat.getPlat().getRecette();
        for (Ingredient ingredient : recette.getRecette()){
            double quantiteRecette = plat.getQuantite() * plat.getPlat().getProportion() * ingredient.get_Qty();
            double quantiteInventaire = inventaire.getIngredientQty(ingredient);

            if (quantiteInventaire < quantiteRecette){
                plat.setEtat(new ImpossibleServir());
                return false;
            }

        }
        return true;
    }

    private void terminer(PlatChoisi plat){
        plat.setEtat(new Terminer());
    }
    private PlatChoisi servir(PlatChoisi plat){
        plat.setEtat(new Servi());
        return plat;
    }
    public PlatChoisi cuisiner(PlatChoisi plat){
        plat.setEtat(new Commande());
        if(verifierIngredient(plat)){
            preparer(plat);
            terminer(plat);
            servir(plat);
            return plat;
        } else {
            return null;
        }
    }
}

