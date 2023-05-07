package menufact.facture;

import ingredients.exceptions.IngredientException;
import ingredients.factory.ConcreteCreatorFruit;
import ingredients.instanceIngredient.*;
import inventaire.Inventaire;
import inventaire.ingredientPlat;
import menufact.Client;
import menufact.chef;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactureControllerTest {

    @Test
    void afficheFacture() throws PlatException, IngredientException, FactureException {



        ArrayList<Ingredient> ingredientsRecette= new ArrayList<>();

        Inventaire inventaire= Inventaire.getInstance();
        inventaire.ajouter(TypeIngredient.FRUIT, new EtatSolide(50), "fraise");

        groupeIngredient groupeFraise= new groupeIngredient(TypeIngredient.FRUIT, new EtatSolide(5));
        Ingredient fraise= ConcreteCreatorFruit.creer(groupeFraise, "fraise");
        ingredientsRecette.add(fraise);
        ingredientPlat recette= new ingredientPlat(ingredientsRecette);

        PlatAuMenu plat1= new PlatAuMenu(1, "menoum plat aux fruits", 10.0);
        plat1.setRecette(recette);


        PlatChoisi pch1= new PlatChoisi(plat1, 2);

        System.out.println("== New menufact.facture.Facture");
        Facture facture = new Facture("Ma facture");
        FactureView view= new FactureView();
        FactureController controller= new FactureController(facture,view);
        Client kevin= new Client(01,"kevin", "abshsh");
        chef gustau= chef.getInstance();
        gustau.setNom("gustau");
        controller.associerClient(kevin);
        controller.observer(gustau);
        System.out.println(controller.afficheFacture());

        System.out.println("== Ajout d'un plat choisie à la facture");
        facture.ajoutePlat(pch1);
        System.out.println(controller.afficheFacture());

    }

    @Test
    void genereFacture() {
    }
}