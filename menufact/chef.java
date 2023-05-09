package menufact;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.Ingredient;
import inventaire.Inventaire;
import menufact.exceptions.MenuException;
import menufact.plats.PlatChoisi;
import menufact.plats.etatPlat.*;
import inventaire.ingredientPlat;
import menufact.plats.exceptions.PlatException;

/**
 * class chef pour le chef qui cuisine les plats
 */
public class chef {
    private static chef instance = null;
    private String nom;

    /**
     * constructor chef
     * private constructor pour singleton
     */
    private chef(){}

    /**
     * cree object chef s'il n'en existe pas
     * @return object chef
     */
    public static chef getInstance(){
        if (instance == null){
            instance = new chef();
        }
        return instance;
    }

    /**
     *
     * @return nom du chef
     */
    public String getNom(){
        return nom;
    }

    /**
     *
     * @param nom du chef a set
     */
    public void setNom(String nom){
        if(this.nom == null) {
            this.nom = nom;
        }
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Chef : " + nom + "\n";
    }
    private void preparer(PlatChoisi platapreparer) throws IngredientException, MenuException {
        platapreparer.setEtat(new Preparation());

        Inventaire inventaire = Inventaire.getInstance();
        ingredientPlat recette = platapreparer.getPlat().getRecette();

        inventaire.consommerRecette(recette, platapreparer.getQuantite(), platapreparer.getPlat().getProportion());

    }

    /**
     *
     * @param plat avec les ingredients a verifier
     * @return vrai si ingredient dans l'inventaire, false sinon
     */

    private boolean verifierIngredient(PlatChoisi plat) throws IngredientException, MenuException {
        Inventaire inventaire = Inventaire.getInstance();
        ingredientPlat recette = plat.getPlat().getRecette();
        for (Ingredient ingredient : recette.getRecette()){
            double quantiteRecette = plat.getQuantite() * plat.getPlat().getProportion() * ingredient.get_Qty();
            double quantiteInventaire = inventaire.getIngredientQty(ingredient);

            if (quantiteInventaire < quantiteRecette){
                plat.setEtat(new ImpossibleServir());
                throw new IngredientException("Manque Ingredient : " + ingredient.getNom());
            }

        }
        return true;
    }

    private void terminer(PlatChoisi plat) throws MenuException {
        plat.setEtat(new Terminer());
    }
    private PlatChoisi servir(PlatChoisi plat) throws MenuException {
        plat.setEtat(new Servi());
        return plat;
    }
    public PlatChoisi cuisiner(PlatChoisi plat) throws IngredientException, PlatException, MenuException {
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

