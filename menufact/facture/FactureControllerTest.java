package menufact.facture;

import ingredients.exceptions.IngredientException;
import ingredients.factory.ConcreteCreatorFruit;
import ingredients.instanceIngredient.*;
import inventaire.Inventaire;
import inventaire.ingredientPlat;
import menufact.Client;
import menufact.chef;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import org.junit.jupiter.api.BeforeEach;
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




        Facture facture = new Facture("Ma facture");
        FactureView view= new FactureView();
        FactureController controller= new FactureController(facture,view);



        Client kevin= new Client(01,"kevin", "abshsh");

        chef gustau= chef.getInstance();
        gustau.setNom("gustau");
        controller.associerClient(kevin);
        controller.observer(gustau);

        String expectedString= "menufact.facture.Facture{date=null, description='Ma facture', etat=menufact.facture.FactureEtatOuverte@12d3a4e9, platchoisi=[], courant=-1, client=menufact.Client{idClient=1, nom='kevin', numeroCarteCredit='abshsh'}, TPS=0.05, TVQ=0.095}";


        assertEquals(expectedString, controller.afficheFacture());


        String expectedString2= "menufact.facture.Facture{date=null, description='Ma facture', etat=menufact.facture.FactureEtatOuverte@12d3a4e9, platchoisi=[menufact.plats.PlatChoisi{quantite=2, plat=menufact.plats.PlatAuMenu{code=1, description='menoum plat aux fruits', prix=10.0}\n}], courant=-1, client=menufact.Client{idClient=1, nom='kevin', numeroCarteCredit='abshsh'}, TPS=0.05, TVQ=0.095}";
        controller.ajoutePlat(pch1);
        assertEquals(expectedString2, controller.afficheFacture());

    }

    @Test
    void genereFacture() throws IngredientException, PlatException, MenuException, FactureException {

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




        Facture facture = new Facture("Ma facture");
        FactureView view= new FactureView();
        FactureController controller= new FactureController(facture,view);



        Client kevin= new Client(01,"kevin", "abshsh");

        chef gustau= chef.getInstance();
        gustau.setNom("gustau");
        controller.associerClient(kevin);
        controller.observer(gustau);





        controller.ajoutePlat(pch1);
        controller.payer();
        String expectedString="Facture generee.\n" +
                "Date:null\n" +
                "Description: Ma facture\n" +
                "Client:kevin\n" +
                "Les plats commandes:\n" +
                "Seq   Plat         Prix   Quantite\n" +
                "1     menoum plat aux fruits  10.0      2\n" +
                "          TPS:               1.0\n" +
                "          TVQ:               1.995\n" +
                "          Le total est de:   22.995\n";
        assertEquals(expectedString,controller.genereFacture());


    }
}