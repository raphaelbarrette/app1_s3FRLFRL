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

    private Inventaire inventaire;
    ArrayList<Ingredient> ingredientsRecette=new ArrayList<>();
    groupeIngredient groupeFraise;
    Ingredient fraise;
    ingredientPlat recette;
    PlatAuMenu plat1;
    PlatChoisi pch1;
    Facture facture;
    FactureView view;
    FactureController controller;
    Client kevin;
    chef gustau;

    @BeforeEach
    void setUp() throws IngredientException, PlatException {
        groupeFraise=new groupeIngredient(TypeIngredient.FRUIT, new EtatSolide(5));
        fraise= ConcreteCreatorFruit.creer(groupeFraise, "fraise");

        ingredientsRecette= new ArrayList<>();
        ingredientsRecette.add(fraise);

        inventaire = Inventaire.getInstance();
        inventaire.ajouter(TypeIngredient.FRUIT, new EtatSolide(50), "fraise");



        recette= new ingredientPlat(ingredientsRecette);

        plat1= new PlatAuMenu(1, "menoum plat aux fruits", 10.0);
        plat1.setRecette(recette);

        pch1= new PlatChoisi(plat1, 2);

        facture = new Facture("Ma facture");
        view= new FactureView();
        controller= new FactureController(facture,view);

        kevin= new Client(01,"kevin", "abshsh");
        gustau= chef.getInstance();
        gustau.setNom("gustau");


    }

    @Test
    void afficheFacture() throws PlatException, IngredientException, FactureException {
        controller.associerClient(kevin);
        controller.observer(gustau);

        String expectedString= "menufact.facture.Facture{date=null, description='Ma facture', etat=Facture etat ouverte, platchoisi=[], courant=-1, client=menufact.Client{idClient=1, nom='kevin', numeroCarteCredit='abshsh'}, TPS=0.05, TVQ=0.095}";


        assertEquals(expectedString, controller.afficheFacture());


        String expectedString2= "menufact.facture.Facture{date=null, description='Ma facture', etat=Facture etat ouverte, platchoisi=[menufact.plats.PlatChoisi{quantite=2, plat=menufact.plats.PlatAuMenu{code=1, description='menoum plat aux fruits', prix=10.0}\n}], courant=-1, client=menufact.Client{idClient=1, nom='kevin', numeroCarteCredit='abshsh'}, TPS=0.05, TVQ=0.095}";
        controller.ajoutePlat(pch1);
        assertEquals(expectedString2, controller.afficheFacture());

    }

    @Test
    void genereFacture() throws IngredientException, PlatException, MenuException, FactureException {
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
                "          TVQ:               1.9\n" +
                "          Le total est de:   22.9\n";
        assertEquals(expectedString,controller.genereFacture());


    }

    @Test
    void associerClient(){
        controller.associerClient(kevin);
        assertEquals(kevin,facture.getClient());
    }

    @Test
    void observer(){
        controller.observer(gustau);
        assertEquals(gustau,facture.getChef());

    }

    @Test
    void payer() throws FactureException {
        controller.payer();
        FactureEtat etatPayee = new FactureEtatPayee();
        assertTrue(facture.getEtat() instanceof FactureEtatPayee);
    }
    @Test
    void fermer() throws FactureException {
        controller.fermer();
        FactureEtat etatFermee = new FactureEtatFermee();
        assertTrue(facture.getEtat() instanceof FactureEtatFermee);
    }

    @Test
    void ouvrir() throws FactureException {
        controller.fermer();
        controller.ouvrir();
        FactureEtat etatOuvrir = new FactureEtatOuverte();
        assertTrue(facture.getEtat() instanceof FactureEtatOuverte);
    }

    @Test
    void ajoutePlat() throws PlatException, FactureException {
        controller.observer(gustau);
        controller.ajoutePlat(pch1);
        ArrayList<PlatChoisi> expectedPlats = new ArrayList<>();
        expectedPlats.add(pch1);
        assertEquals(expectedPlats, facture.getPlatsChoisis() );

    }

    @Test
    void getSousTotal() throws PlatException, FactureException {
        controller.observer(gustau);
        controller.ajoutePlat(pch1);
        double expectedSousTotal= 20.0;
        assertEquals(expectedSousTotal, controller.getSousTotal() );

    }

    @Test
    void getTps() throws PlatException, FactureException {
        controller.observer(gustau);
        controller.ajoutePlat(pch1);
        double expectedTps= 20.0*0.05;
        assertEquals(expectedTps, controller.getTps() );

    }

    @Test
    void getTvq() throws PlatException, FactureException {
        controller.observer(gustau);
        controller.ajoutePlat(pch1);
        double expectedTvq= 20.0*0.095;
        assertEquals(expectedTvq, controller.getTvq());
    }

    void getTotal() throws PlatException, FactureException {
        controller.observer(gustau);
        controller.ajoutePlat(pch1);
        double expectedTotal= 20.0*0.095+20.0*0.05+20.0;
        assertEquals(expectedTotal,controller.getTotal());

    }



}

