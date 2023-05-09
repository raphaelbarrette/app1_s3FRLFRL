package menufact;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.*;
import inventaire.Inventaire;
import inventaire.ingredientPlat;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.FactureController;
import menufact.facture.FactureView;
import menufact.facture.exceptions.FactureException;
import menufact.plats.BuilderPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
import menufact.plats.exceptions.PlatException;

public class TestMenuFact01{
    public static void main(String[] args) throws IngredientException, PlatException, FactureException, MenuException {
        System.out.println("==================== DEBUT DE L'ITERATION ===========================\n \n");
        System.out.println("===================== Creation des ingredients =======================");

        Ingredient fromage_grain = new Laitier("fromage_grain", new EtatSolide(25));
        System.out.print("Ingredient 1 : " + fromage_grain.toString());

        Ingredient frites = new Legume("frites", new EtatSolide(30));
        System.out.print("Ingredient 2 : " + frites.toString());

        Ingredient sauce = new Legume("sauce", new EtatLiquide(20));
        System.out.print("Ingredient 3 : " + sauce.toString());

        Ingredient pain = new Legume("pain", new EtatSolide(2));
        System.out.print("Ingredient 4 : " + pain.toString());

        Ingredient boulette = new Viande("boulette", new EtatSolide(1));
        System.out.print("Ingredient 5 : " + boulette.toString());

        Ingredient tomates = new Legume("tomates", new EtatSolide(2));
        System.out.print("Ingredient 6 : " + tomates.toString());

        Ingredient ketchup = new Epice("ketchup", new EtatLiquide(10));
        System.out.print("Ingredient 7 : " + ketchup.toString());
        System.out.println(" ");
        System.out.println("====================== Creation de l'inventaire =============================");
        Inventaire inventaire = Inventaire.getInstance();
        System.out.print("Inventaire vide : " + inventaire.toString());
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("====================== Remplissage de l'inventaire ==========================");
        inventaire.ajouter(new Ingredient[]{fromage_grain, frites, sauce, pain, boulette, tomates, ketchup});
        System.out.println("Inventaire remplie : " + inventaire.toString());
        System.out.println(" ");

        System.out.println("========================= Creation des plats ================================");
        BuilderPlat plat_poutine = new BuilderPlat();
        plat_poutine.build_description("poutine");
        plat_poutine.build_prix(10.0);
        BuilderPlat plat_burger = new BuilderPlat();
        plat_burger.build_description("burger");
        plat_burger.build_prix(15.0);
        System.out.print("Plats vide : " + plat_poutine.getPlat().toString() + plat_burger.getPlat().toString());

        System.out.println(" ");
        System.out.println("==================== Creation et remplissage des recettes =====================");
        ingredientPlat recette_poutine = new ingredientPlat(new Ingredient[]{fromage_grain, frites, sauce});
        ingredientPlat recette_burger = new ingredientPlat(new Ingredient[]{pain, boulette, ketchup, tomates});
        System.out.println("Recettes : " + recette_poutine.toString() + recette_poutine.toString());

        System.out.println(" ");
        System.out.println("=================== Association des recettes et plats =========================");
        plat_poutine.build_recette(recette_poutine);
        plat_burger.build_recette(recette_burger);
        System.out.println("Plats et recettes associes");
        System.out.println(" ");

        System.out.println("============================= Creation Chef ===================================");
        chef cuisinier = chef.getInstance();
        cuisinier.setNom("Kevin");
        System.out.println(cuisinier.toString());
        System.out.println(" ");

        System.out.println("============================= Creation du menu ===================================");
        Menu menu = Menu.getInstance("Menu");
        System.out.println("Menu vide : " + menu.toString());
        System.out.println(" ");

        System.out.println("============================= Remplissage du menu ================================");
        menu.ajoute(plat_poutine.getPlat());
        menu.ajoute(plat_burger.getPlat());
        System.out.println("Menu rempli : " + menu.toString());
        System.out.println(" ");

        System.out.println("============================= Creation du client =================================");
        Client client = new Client(10, "Alexis", "1234-5678-9012-3456");
        System.out.println(client.toString());
        System.out.println(" ");

        System.out.println("============================= Creation de la facture =============================");
        Facture facture = new Facture("Facture");
        FactureView factureView = new FactureView();
        FactureController factureController = new FactureController(facture, factureView);
        System.out.println(factureController.afficheFacture());
        System.out.println(" ");

        System.out.println("========================== Choix des plat par le client=========================");
        PlatChoisi poutine_choisi = new PlatChoisi(plat_poutine.getPlat(), 1);
        PlatChoisi burger_choisi = new PlatChoisi(plat_burger.getPlat(), 1);
        System.out.println("Plats Choisis : " + poutine_choisi.toString() + burger_choisi.toString());
        System.out.println(" ");

        System.out.println("=========================== Ajout des Plats a la facture ===============================");
        factureController.observer(cuisinier);
        factureController.ajoutePlat(poutine_choisi);
        factureController.ajoutePlat(burger_choisi);
        System.out.println(factureController.afficheFacture());
        System.out.println(" ");


        System.out.println("================================ Paiement de la facture ================================");
        factureController.payer();
        System.out.println(factureController.afficheFacture());
        System.out.println(" ");

        System.out.println("================================ Generation de la Facture ==============================");
        factureController.associerClient(client);
        System.out.println(factureController.genereFacture());
        System.out.println("\n");

        System.out.print("==================================== FIN DE L'ITERATION ====================================");

    }
}















//
//public class TestMenuFact01 {
//    public static void main(String[] args) {
//
//        try {
//            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
//            PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
//            System.out.println(p1);
//
//            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
//            PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25);
//            System.out.println(p2);
//
//            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
//            PlatSante ps1 = new PlatSante(2, "Salade", 5.25, 100, 10, 1);
//            System.out.println(ps1);
//
//            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
//            PlatSante ps2 = new PlatSante(3, "Salade Cesar", 8.25, 100, 10, 1);
//            System.out.println(ps2);
//
//            System.out.println("===menufact.Menu ajout avec 4 plats");
//            Menu menu = new Menu("Menu1");
//            menu.ajoute(p1);
//            menu.ajoute(p2);
//            menu.ajoute(ps1);
//            menu.ajoute(ps2);
//            System.out.println(menu);
//
//            System.out.println("===menufact.Menu position 1, plat à la position 0");
//            menu.position(0);
//            System.out.println(menu.platCourant());
//
//            System.out.println("===menufact.Menu position 1, plat à la position suivante 1");
//            menu.positionSuivante();
//            System.out.println(menu.platCourant());
//
//            System.out.println("== Plat choisi");
//            PlatChoisi pch1 = new PlatChoisi(p1, 5);
//            System.out.println(pch1);
//
//            System.out.println("== New menufact.facture.Facture");
//            Facture facture = new Facture("Ma facture");
//            System.out.println(facture);
//
//            System.out.println("== Ajout d'un plat choisie à la facture");
//            facture.ajoutePlat(pch1);
//            System.out.println(facture);
//            System.out.println(facture.sousTotal());
//
//            System.out.println("== Ajout d'un plat choisie à la facture");
//            PlatChoisi pch2 = new PlatChoisi(p2, 10);
//            facture.ajoutePlat(pch2);
//            System.out.println(facture);
//            System.out.println(facture.sousTotal());
//
//            System.out.println(facture.total());
//            facture.ouvrir();
//            System.out.println(facture);
//            System.out.println("Etat = " + facture.getEtat());
//
//            facture.fermer();
//            System.out.println(facture);
//            System.out.println("Etat = " + facture.getEtat());
//
//            facture.ouvrir();
//            System.out.println(facture);
//            System.out.println("Etat = " + facture.getEtat());
//
//            facture.payer();
//            System.out.println(facture);
//            System.out.println("Etat = " + facture.getEtat());
//
//            facture.ouvrir();
//            System.out.println(facture);
//            System.out.println("Etat = " + facture.getEtat());
//        }catch (Exception | PlatException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//
//    }
//}

//import menufact.facture.Facture;
//import menufact.facture.FactureController;
//import menufact.facture.FactureView;
//import menufact.plats.PlatAuMenu;
//import menufact.plats.PlatChoisi;
//import menufact.plats.PlatSante;
//import menufact.plats.exceptions.PlatException;
//
//public class TestMenuFact01 {
//    public static void main(String[] args) {
//
//        try {
//            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
//            PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
//            System.out.println(p1);
//
//            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
//            PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25);
//            System.out.println(p2);
//
//            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
//            PlatSante ps1 = new PlatSante(2, "Salade", 5.25, 100, 10, 1);
//            System.out.println(ps1);
//
//            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
//            PlatSante ps2 = new PlatSante(3, "Salade Cesar", 8.25, 100, 10, 1);
//            System.out.println(ps2);
//
//
//            System.out.println("===menufact.Menu ajout avec 4 plats");
//            Menu menu = Menu.getInstance("Menu 1");
//            menu.ajoute(p1);
//            menu.ajoute(p2);
//            menu.ajoute(ps1);
//            menu.ajoute(ps2);
//            System.out.println(menu);
//
//            System.out.println("===menufact.Menu position 1, plat à la position 0");
//            menu.position(0);
//            System.out.println(menu.platCourant());
//
//            System.out.println("===menufact.Menu position 1, plat à la position suivante 1");
//            menu.positionSuivante();
//            System.out.println(menu.platCourant());
//
//            System.out.println("== Plat choisi");
//            PlatChoisi pch1 = new PlatChoisi(p1, 5);
//            System.out.println(pch1);
//
//            System.out.println("== New menufact.facture.Facture");
//            Facture facture = new Facture("Ma facture");
//            FactureView view= new FactureView();
//            FactureController controller= new FactureController(facture,view);
//            Client kevin= new Client(01,"kevin", "abshsh");
//            chef gustau= chef.getInstance();
//            gustau.setNom("gustau");
//            controller.associerClient(kevin);
//            controller.observer(gustau);
//            System.out.println(controller.afficheFacture());
//
//            System.out.println("== Ajout d'un plat choisie à la facture");
//            facture.ajoutePlat(pch1);
//            System.out.println(controller.afficheFacture());

            /*
            System.out.println(facture.sousTotal());

            System.out.println("== Ajout d'un plat choisie à la facture");
            PlatChoisi pch2 = new PlatChoisi(p2, 10);
            facture.ajoutePlat(pch2);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println(facture.total());
            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.fermer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.payer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());
            */

//        }catch (Exception fe)
//        {
//            System.out.println(fe.getMessage());
//        } catch (PlatException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
