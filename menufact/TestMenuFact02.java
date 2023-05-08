package menufact;

import ingredients.exceptions.IngredientException;
import ingredients.instanceIngredient.*;
import inventaire.Inventaire;
import inventaire.ingredientPlat;
import menufact.facture.FactureEtatFermee;
import menufact.facture.FactureEtatOuverte;
import menufact.facture.FactureEtatPayee;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.*;
import menufact.plats.etatPlat.*;

import menufact.plats.etatPlat.Servi;
import menufact.plats.exceptions.PlatException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestIngredient {

    @BeforeEach
    void setup() {
    }

    @Test
    void getNom() throws IngredientException {
        EtatIngredient solide = new EtatSolide(10);
        Ingredient i1 = new Viande("boeuf",solide);
        assertEquals("boeuf", i1.getNom());
    }
    @Test
    void getEtat() throws IngredientException {
        EtatIngredient solide = new EtatSolide(10);
        EtatIngredient liquide = new EtatLiquide(10);
        Ingredient i1 = new Viande("boeuf",liquide);
        assertEquals(liquide, i1.getEtat());
    }
    @Test
    void get_Qty() throws IngredientException {
        EtatIngredient solide = new EtatSolide(10);
        Ingredient i1 = new Viande("boeuf",solide);
        assertEquals(10, i1.get_Qty());
    }
    @Test
    void equals() throws IngredientException {
        EtatIngredient solide = new EtatSolide(10);
        Ingredient i1 = new Viande("boeuf",solide);
        Ingredient i2 = new Viande("boeuf",solide);
        Ingredient i3 = new Viande("poulet",solide);
        assertEquals(true, i1.equals(i2));
        assertEquals(false, i1.equals(i3));
    }

}

class InventaireTest {
    Inventaire inventaire = Inventaire.getInstance();
    @Test
    void ajouter() throws IngredientException {
        inventaire.ajouter(TypeIngredient.FRUIT, new EtatSolide(10), "Fraise");
        inventaire.ajouter(TypeIngredient.VIANDE, new EtatSolide(5), "Boeuf");
//        System.out.print(inventaire.toString());
    }
    @Test
    void getInstance() throws IngredientException{
        inventaire.ajouter(TypeIngredient.FRUIT, new EtatSolide(10), "Fraise");
        inventaire.ajouter(TypeIngredient.VIANDE, new EtatSolide(5), "Boeuf");
        String toStringInventaire1 = inventaire.toString();
        Inventaire inventaire1 = Inventaire.getInstance();
        assertEquals(toStringInventaire1, inventaire1.toString());
    }
    @Test
    void clearInventaire() throws IngredientException{
        inventaire.ajouter(TypeIngredient.FRUIT, new EtatSolide(10), "Fraise");
        inventaire.ajouter(TypeIngredient.VIANDE, new EtatSolide(5), "Boeuf");
        inventaire.clearInventaire();
        assertEquals(null, inventaire.returnInstance());
        assertEquals(0, inventaire.getSize());
    }
    @Test
    void getIngredient() throws IngredientException{
        Ingredient i1 = new Fruit("Fraise", new EtatSolide(10));
        inventaire.ajouter(i1);
        assertEquals(i1, inventaire.getIngredient(i1));
    }
    @Test
    void getSize() throws IngredientException{
        inventaire.clearInventaire();
        Ingredient i1 = new Fruit("Fraise", new EtatSolide(10));
        Ingredient i2 = new Epice("Curcuma", new EtatSolide(5));
        inventaire.ajouter(i1);
        inventaire.ajouter(i2);
        assertEquals(2, inventaire.getSize());
    }
    @Test
    void getIngredientQty() throws IngredientException{
        inventaire.clearInventaire();
        Ingredient i1 = new Fruit("Fraise", new EtatSolide(10));
        inventaire.ajouter(i1);
        assertEquals(10, inventaire.getIngredientQty(i1));
    }
    @Test
    void consommerRecette() throws IngredientException{
        Ingredient i1 = new Fruit("Fraise", new EtatSolide(10));
        Ingredient i2 = new Laitier("Lait", new EtatLiquide(5));
        Ingredient i3 = new Viande("Poulet", new EtatSolide(20));

        Ingredient[] liste = {i1, i2, i3};
        ingredientPlat recette = new ingredientPlat(liste);
        inventaire.clearInventaire();
        Ingredient i4 = new Fruit("Fraise", new EtatSolide(15));
        Ingredient i5 = new Laitier("Lait", new EtatLiquide(10));
        Ingredient i6 = new Viande("Poulet", new EtatSolide(1));
        inventaire.ajouter(i5);
        inventaire.ajouter(i4);
        inventaire.ajouter(i6);
        assertThrows(IngredientException.class, () ->{
            inventaire.consommerRecette(recette, 1, 1);
        });
        assertEquals(5, inventaire.getIngredientQty(i4));
        assertEquals(5, inventaire.getIngredientQty(i5));
    }
    @Test
    void returnInstance(){
        assertEquals(inventaire, inventaire.returnInstance());
    }
}

class chefTest {
    chef cuisinier = chef.getInstance();
    @Test
    void setNomgetNom(){
        cuisinier.setNom("Kevin");
        String nom = cuisinier.getNom();
        assertEquals("Kevin", nom);
    }
    @Test
     void cuisiner() throws IngredientException, PlatException {
        Ingredient frite = new Legume("frite", new EtatSolide(25));
        Ingredient fromage = new Laitier("fromage", new EtatSolide(20));
        Ingredient sauce = new Epice("sauce", new EtatLiquide(1));

        ingredientPlat recettePoutine = new ingredientPlat(new Ingredient[] {frite, fromage, sauce});

        PlatAuMenu poutine = new PlatAuMenu(100, "Poutine", 4.50);

        poutine.setRecette(recettePoutine);

        PlatChoisi platChoisi = new PlatChoisi(poutine, 1);

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(new Ingredient[] {frite, fromage, sauce});

        cuisinier.cuisiner(platChoisi);
        assertTrue(platChoisi.getEtat() instanceof Servi);

        inventaire.clearInventaire();
        Ingredient boeuf = new Viande("Boeuf", new EtatSolide(1));
        PlatAuMenu steak = new PlatAuMenu(20, "steak", 15.00);
        ingredientPlat recetteSteak = new ingredientPlat(new Ingredient[] {boeuf});
        steak.setRecette(recetteSteak);
        PlatChoisi steakChoisi = new PlatChoisi(steak, 5);

        inventaire.ajouter(boeuf);
        assertThrows(IngredientException.class, () ->{
            cuisinier.cuisiner(steakChoisi);
        });
    }
}

class FactureTest {
    Client client = new Client(10, "Kevin", "27");
    Facture facture = new Facture("Facture 1");
    @Test
    void ouvrir() throws FactureException{
        assertThrows(FactureException.class, ()->{
            facture.ouvrir();
        });
    }
    @Test
    void fermee_getEtat() throws FactureException {
        facture.fermer();
        assertTrue(facture.getEtat() instanceof FactureEtatFermee);
    }
    @Test
    void paye_getEtat() throws FactureException{
        facture.payer();
        assertTrue(facture.getEtat() instanceof FactureEtatPayee);
    }
    //@Test

}

class PlatEnfantTest {
    @Test
    void setProportion_getProportion() throws PlatException{
        PlatEnfant platEnfant = new PlatEnfant(10, "plat enfant", 2.0, 0.5);
        double proportion = platEnfant.getProportion();
        assertEquals(0.5, proportion);
        platEnfant.setProportion(1.0);
        proportion = platEnfant.getProportion();
        assertEquals(1.0, proportion);
    }
}

class PlatSanteTest {
    @Test
    void getKcal_setKcal() throws PlatException{
        PlatSante platSante = new PlatSante();
        double Kcal = 1.0;
        platSante.setKcal(Kcal);
        assertEquals(Kcal, platSante.getKcal());
    }
    @Test
    void getChol_setChol() throws PlatException{
        PlatSante platSante = new PlatSante();
        double Chol = 2.0;
        platSante.setChol(Chol);
        assertEquals(Chol, platSante.getChol());
    }
    @Test
    void getGras_setGras() throws PlatException{
        PlatSante platSante = new PlatSante();
        double Gras = 3.0;
        platSante.setGras(Gras);
        assertEquals(Gras, platSante.getGras());
    }
}

class PlatChoisiTest {
    @Test
    public void testConstructeurAvecQuantitePositive() throws PlatException{
        PlatAuMenu plat = new PlatAuMenu(1, "Poulet", 10.99);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);
        assertEquals(plat, platChoisi.getPlat());
        assertEquals(2, platChoisi.getQuantite());
    }

    @Test
    public void testConstructeurAvecQuantiteNegative() throws PlatException{
        PlatAuMenu plat = new PlatAuMenu(1, "Poulet", 10.99);
        assertThrows(PlatException.class, () -> new PlatChoisi(plat, -2));
    }

    @Test
    public void testToString() throws PlatException{
        PlatAuMenu plat = new PlatAuMenu(1, "Poulet", 10.99);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);
        String expectedString = "menufact.plats.PlatChoisi{quantite=2, plat=" + plat.toString() + "}";
        assertEquals(expectedString, platChoisi.toString());
    }

    @Test
    public void testGetQuantite() throws PlatException{
        PlatAuMenu plat = new PlatAuMenu(1, "Poulet", 10.99);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);
        assertEquals(2, platChoisi.getQuantite());
    }

    @Test
    public void testGetPlat() throws PlatException{
        PlatAuMenu plat = new PlatAuMenu(1, "Poulet", 10.99);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);
        assertEquals(plat, platChoisi.getPlat());
    }

    @Test
    public void testPlatChoisiGetQuantite() throws PlatException {
        PlatAuMenu plat = new PlatAuMenu(1, "Plat test", 10.0);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);

        assertEquals(2, platChoisi.getQuantite());
    }

    @Test
    public void testPlatChoisiSetQuantite() throws PlatException {
        PlatAuMenu plat = new PlatAuMenu(1, "Plat test", 10.0);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);

        platChoisi.setQuantite(3);

        assertEquals(3, platChoisi.getQuantite());
    }

    @Test
    public void testPlatChoisiGetPlat() throws PlatException {
        PlatAuMenu plat = new PlatAuMenu(1, "Plat test", 10.0);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);
        assertEquals(plat, platChoisi.getPlat());
    }

    @Test
    public void testPlatChoisiGetEtat() throws PlatException {
        PlatAuMenu plat = new PlatAuMenu(1, "Plat test", 10.0);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);

        assertNull(platChoisi.getEtat());
    }

    @Test
    public void testPlatChoisiSetEtatValide() throws PlatException {
        PlatAuMenu plat = new PlatAuMenu(1, "Plat test", 10.0);
        PlatChoisi platChoisi = new PlatChoisi(plat, 2);

        CommandeEtat nouvelEtat = new Preparation();
        platChoisi.setEtat(nouvelEtat);

        assertEquals(nouvelEtat, platChoisi.getEtat());
    }
}

class PlatAuMenuTest {
    private PlatAuMenu plat;

    @BeforeEach
    public void setUp() throws PlatException {
        plat = new PlatAuMenu(1, "Poutine", 8.99);
    }

    @Test
    public void testGetCode() {
        assertEquals(1, plat.getCode());
    }

    @Test
    public void testSetCode() {
        plat.setCode(2);
        assertEquals(2, plat.getCode());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Poutine", plat.getDescription());
    }

    @Test
    public void testSetDescription() {
        plat.setDescription("Poutine au foie gras");
        assertEquals("Poutine au foie gras", plat.getDescription());
    }

    @Test
    public void testGetPrix() {
        assertEquals(8.99, plat.getPrix());
    }

    @Test
    public void testSetPrix() {
        plat.setPrix(9.99);
        assertEquals(9.99, plat.getPrix());
    }

    @Test
    public void testSetRecette() throws IngredientException {
        Ingredient i1 = new Legume("Pommes de terre", new EtatSolide(10));
        Ingredient i2 = new Laitier("Fromage en grains", new EtatSolide(5));
        Inventaire inventaire = Inventaire.getInstance();
        try {
            inventaire.ajouter(i1);
            inventaire.ajouter(i2);
        } catch (IngredientException e) {
            e.printStackTrace();
        }
        ingredientPlat recette = new ingredientPlat();
        try {
            recette.ajouter(i1);
            recette.ajouter(i2);
        } catch (IngredientException e) {
            e.printStackTrace();
        }
        plat.setRecette(recette);
        assertEquals(recette, plat.getRecette());
    }

    @Test
    public void testPrixNegatif() {
        PlatException exception = assertThrows(PlatException.class, () -> {
            PlatAuMenu plat = new PlatAuMenu(1, "Poutine", -8.99);
        });
        assertEquals("PlatException : Impossible : prix negatif", exception.getMessage());
    }

    @Test
    public void testProportion() {
        assertEquals(1.0, plat.getProportion());
    }
}

class BuilderPlatTest {

    @Test
    public void testBuildDescription() {
        BuilderPlat builder = new BuilderPlat();
        String description = "Plat de pâtes à la sauce tomate";
        builder.build_description(description);
        PlatAuMenu plat = builder.getPlat();

        assertEquals(description, plat.getDescription());
    }

    @Test
    public void testBuildDescriptionEmpty() {
        BuilderPlat builder = new BuilderPlat();
        String description = "";
        builder.build_description(description);
        PlatAuMenu plat = builder.getPlat();

        assertEquals(description, plat.getDescription());
    }

    @Test
    public void testBuildDescriptionNull() {
        BuilderPlat builder = new BuilderPlat();
        String description = null;
        builder.build_description(description);
        PlatAuMenu plat = builder.getPlat();

        assertNull(plat.getDescription());
    }
}

class BuilderPlatEnfantTest {
    @Test
    public void testBuildProportion() {
        BuilderPlatEnfant builder = new BuilderPlatEnfant();
        double proportion = 0.5;
        builder.build_proportion(proportion);
        PlatEnfant plat = builder.getPlat();
        assertEquals(proportion, plat.getProportion(), 0.001);
    }

    @Test
    public void testClear() throws IngredientException {
        BuilderPlatEnfant builder = new BuilderPlatEnfant();
        builder.build_description("test plat");
        builder.build_prix(10.0);
        Ingredient ingredient = new Viande("test", new EtatSolide(5));
        ingredientPlat recette = new ingredientPlat(new Ingredient[] {ingredient});
        builder.build_recette(recette);
        builder.build_proportion(0.5);

        builder.clear();

        PlatEnfant plat = builder.getPlat();
        assertNull(plat.getDescription());
        assertEquals(0.0, plat.getPrix(), 0.001);
        assertNull(plat.getRecette());
        assertEquals(1.0, plat.getProportion(), 0.001);
    }
}

class BuilderPlatSanteTest {

    @Test
    public void testBuild_kcal() {
        BuilderPlatSante builder = new BuilderPlatSante();
        double kcal = 500;

        builder.build_kcal(kcal);
        PlatSante platSante = builder.getPlat();

        assertEquals(kcal, platSante.getKcal(), 0.001);
    }

    @Test
    public void testBuild_chol() {
        BuilderPlatSante builder = new BuilderPlatSante();
        double chol = 50;

        builder.build_chol(chol);
        PlatSante platSante = builder.getPlat();

        assertEquals(chol, platSante.getChol(), 0.001);
    }

    @Test
    public void testBuild_gras() {
        BuilderPlatSante builder = new BuilderPlatSante();
        double gras = 20;

        builder.build_gras(gras);
        PlatSante platSante = builder.getPlat();

        assertEquals(gras, platSante.getGras(), 0.001);
    }

}

class MenuTest {

    @Test
    public void testGetInstance() {
        Menu m1 = Menu.getInstance("Menu1");
        Menu m2 = Menu.getInstance("Menu2");
        assertEquals(m1, m2); // should return true since getInstance() returns the same instance
    }

    @Test
    public void testAjoute() throws PlatException {
        Menu m = Menu.getInstance("Menu");
        m.clear();
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 20);
        PlatAuMenu p2 = new PlatAuMenu(10, "P2", 20);
        m.ajoute(p1);
        m.ajoute(p2);
        assertEquals(2, m.getSize()); // should return true since there are 2 plats in the menu
    }

    @Test
    public void testGetDescription() {
        Menu m = Menu.getInstance("Menu");
        m.setDescription("Menu");
        assertEquals("Menu", m.getDescription()); // should return true since description was set to "Menu"
    }

    @Test
    public void testSetDescription() {
        Menu m = Menu.getInstance("Menu");
        m.setDescription("New Menu");
        assertEquals("New Menu", m.getDescription()); // should return true since description was updated to "New Menu"
    }

    @Test
    public void testPlatCourant() throws PlatException {
        Menu m = Menu.getInstance("Menu");
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        PlatAuMenu p2 = new PlatAuMenu(10, "P2", 20);
        m.ajoute(p1);
        m.ajoute(p2);
        m.position(1);
        assertEquals(p2.toString(), m.platCourant().toString()); // should return true since platCourant() should return the second plat added to the menu
    }

    @Test
    public void testPositionSuivante() throws MenuException, PlatException {
        Menu m = Menu.getInstance("Menu");
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        PlatAuMenu p2 = new PlatAuMenu(10, "P2", 20);
        m.ajoute(p1);
        m.ajoute(p2);
        m.positionSuivante();
        assertEquals(p2, m.platCourant()); // should return true since platCourant() should return the second plat added to the menu after calling positionSuivante()
    }

    @Test
    public void testPositionSuivanteException() throws MenuException, PlatException {
        Menu m = Menu.getInstance("Menu");
        m.clear();
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        m.ajoute(p1);
        assertThrows(MenuException.class, ()->{
            m.positionSuivante(); // should throw a MenuException since there is only one plat in the menu
        });
    }

    @Test
    public void testPositionPrecedente() throws MenuException, PlatException {
        Menu m = Menu.getInstance("Menu");
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        PlatAuMenu p2 = new PlatAuMenu(10, "P2", 20);
        m.ajoute(p1);
        m.ajoute(p2);
        m.position(1);
        m.positionPrecedente();
        assertEquals(p1, m.platCourant()); // should return true since platCourant() should return the first plat added to the menu after calling positionPrecedente()
    }

    @Test
    public void testClear() throws PlatException {
        Menu m = Menu.getInstance("Menu");
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        m.ajoute(p1);
        m.clear();
        assertEquals(0, m.getSize());
    }
    @Test
    public void testgetSize() throws PlatException {
        Menu m = Menu.getInstance("Menu");
        m.clear();
        PlatAuMenu p1 = new PlatAuMenu(10, "P1", 10);
        m.ajoute(p1);
        assertEquals(1, m.getSize());
    }
}

class ClientTest {

    @Test
    public void testGetIdClient() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        assertEquals(1, client.getIdClient());
    }

    @Test
    public void testSetIdClient() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        client.setIdClient(2);
        assertEquals(2, client.getIdClient());
    }

    @Test
    public void testGetNom() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        assertEquals("John Doe", client.getNom());
    }

    @Test
    public void testSetNom() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        client.setNom("Jane Doe");
        assertEquals("Jane Doe", client.getNom());
    }

    @Test
    public void testGetNumeroCarteCredit() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        assertEquals("1234-5678-9012-3456", client.getNumeroCarteCredit());
    }

    @Test
    public void testSetNumeroCarteCredit() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        client.setNumeroCarteCredit("5555-5555-5555-5555");
        assertEquals("5555-5555-5555-5555", client.getNumeroCarteCredit());
    }

    @Test
    public void testSetNomNull() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        client.setNom(null);
        assertEquals("John Doe", client.getNom());
    }

    @Test
    public void testSetNumeroCarteCreditNull() {
        Client client = new Client(1, "John Doe", "1234-5678-9012-3456");
        client.setNumeroCarteCredit(null);
        assertEquals("1234-5678-9012-3456", client.getNumeroCarteCredit());
    }
}

class ingredientPlatTest {
    @Test
    public void testConstructor1() throws IngredientException {
        Ingredient i1 = new Viande("boeuf", new EtatSolide(2));
        Ingredient i2 = new Legume("concombre", new EtatLiquide(2));
        Ingredient[] ingredients = {i1, i2};
        ingredientPlat plat = new ingredientPlat(ingredients);
        ArrayList<Ingredient> expected = new ArrayList<>();
        expected.add(i1);
        expected.add(i2);
        assertEquals(expected, plat.getRecette());
    }

    @Test
    public void testConstructor2() throws IngredientException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient i1 = new Viande("boeuf", new EtatSolide(2));
        Ingredient i2 = new Legume("concombre", new EtatLiquide(2));
        ingredients.add(i1);
        ingredients.add(i2);
        ingredientPlat plat = new ingredientPlat(ingredients);
        assertEquals(ingredients, plat.getRecette());
    }

    @Test
    public void testAjouter() throws IngredientException {
        ingredientPlat plat = new ingredientPlat();
        Ingredient i1 = new Viande("boeuf", new EtatSolide(2));
        Ingredient i2 = new Legume("concombre", new EtatLiquide(2));
        Ingredient i3 = new Laitier("lait", new EtatLiquide(2));
        plat.ajouter(i1);
        plat.ajouter(i2);
        plat.ajouter(i3);
        ArrayList<Ingredient> expected = new ArrayList<>();
        expected.add(i1);
        expected.add(i2);
        expected.add(i3);
        assertEquals(expected, plat.getRecette());
    }

    @Test
    public void testSetRecette() throws IngredientException {
        ingredientPlat plat = new ingredientPlat();
        Ingredient i1 = new Viande("boeuf", new EtatSolide(2));
        Ingredient i2 = new Legume("concombre", new EtatLiquide(2));
        plat.setRecette(new Ingredient[]{i1, i2});
        ArrayList<Ingredient> expected = new ArrayList<>();
        expected.add(i1);
        expected.add(i2);
        assertEquals(expected, plat.getRecette());
    }
}

































//public class TestMenuFact02 {
//
//    public static void main(String[] args) {
//        boolean trace = true;
//
//        TestMenuFact02 t = new TestMenuFact02();
//
//        PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10);
//        PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20);
//        PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30);
//        PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40);
//        PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50);
//
//
//        PlatSante ps1 = new PlatSante(10,"PlatSante0",10,11,11,11);
//        PlatSante ps2 = new PlatSante(11,"PlatSante1",20,11,11,11);
//        PlatSante ps3 = new PlatSante(12,"PlatSante2",30,11,11,11);
//        PlatSante ps4 = new PlatSante(13,"PlatSante3",40,11,11,11);
//        PlatSante ps5 = new PlatSante(14,"PlatSante4",50,11,11,11);
//
//
//        Menu m1 = new Menu("menufact.Menu 1");
//        Menu m2 = new Menu("menufact.Menu 2");
//
//        Facture f1 = new Facture("Ma facture");
//
//        Client c1 = new Client(1,"Mr Client","1234567890");
//
//
//        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
//        t. test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);
//
//        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);
//
//
//        try {
//            t.test5_DeplacementMenuAvancer(m1);
//        } catch (MenuException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            t.test6_DeplacementMenuReculer(m1);
//        } catch (MenuException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            t.test7_CreerFacture(f1, m1);
//        } catch (FactureException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        t.test8_AjouterClientFacture(f1, c1);
//
//        try {
//            t.test8_AjouterPlatsFacture(f1, m1,1);
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//        catch (MenuException me)
//        {
//            System.out.println(me);
//        }
//
//        t.test9_PayerFacture(f1);
//
//        try {
//            t.test8_AjouterPlatsFacture(f1, m1,1);
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//        catch (MenuException me)
//        {
//            System.out.println(me);
//        }
//
//        try {
//            f1.ouvrir();
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//
//
//
//
//
//
//        System.out.println("FIN DE TOUS LES TESTS...");
//
//        System.out.println(f1.genererFacture());
//    }
//
//    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
//                                                 PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
//    {
//        System.out.println("=== test1_AffichePlatsAuMenu");
//        if(trace)
//        {
//            System.out.println(p1);
//            System.out.println(p2);
//            System.out.println(p3);
//            System.out.println(p4);
//            System.out.println(p5);
//        }
//    }
//
//
//   private void test2_AffichePlatsSante(boolean trace, PlatSante ps1, PlatSante ps2,
//                                               PlatSante ps3, PlatSante ps4, PlatSante ps5)
//    {
//        System.out.println("=== test2_AffichePlatsSante");
//
//        if(trace)
//        {
//            System.out.println(ps1);
//            System.out.println(ps2);
//            System.out.println(ps3);
//            System.out.println(ps4);
//            System.out.println(ps5);
//        }
//    }
//
//
//    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
//    {
//
//        System.out.println("=== test3_AjoutMenu");
//
//        if(trace) {
//            System.out.println(m1);
//            System.out.println(m2);
//        }
//    }
//
//
//    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
//                                        PlatAuMenu p1, PlatAuMenu p2,
//                                        PlatSante ps1, PlatSante ps2,
//                                        Menu m2,
//                                        PlatAuMenu p3, PlatAuMenu p4,
//                                        PlatSante ps3, PlatSante ps4)
//    {
//        System.out.println("=== test4_AjoutPlatsAuMenu");
//        System.out.println("=== Ajout de plats au menu 1");
//        m1.ajoute(p1);
//        m1.ajoute(p2);
//        m1.ajoute(ps1);
//        m1.ajoute(ps2);
//
//
//        System.out.println("=== Ajout de plats au menu 2");
//        m2.ajoute(p3);
//        m2.ajoute(p4);
//        m2.ajoute(ps3);
//        m2.ajoute(ps4);
//
//        if(trace) {
//            System.out.println(m1);
//            System.out.println(m2);
//        }
//    }
//
//
//    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
//    {
//        System.out.println("=== test5_DeplacementMenuAvancer");
//
//        System.out.println("===Selectionner un plat du menu 0");
//        m1.position(0);
//
//        System.out.println("=== Afficher le plat courant");
//        System.out.println(m1.platCourant());
//        try {
//
//            System.out.println("=== Avancer le plat courant");
//            System.out.println("1.");
//            m1.positionSuivante();
//            System.out.println("2.");
//            m1.positionSuivante();
//            System.out.println("3.");
//            m1.positionSuivante();
//            System.out.println("4.");
//            m1.positionSuivante();
//            System.out.println("5.");
//            m1.positionSuivante();
//        }
//        catch (MenuException me)
//        {
//                throw me;
//        }
//    }
//
//
//    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
//    {
//        System.out.println("===test6_DeplacementMenuReculer");
//
//        System.out.println("===Selectionner un plat du menu 3");
//        m1.position(3);
//
//        System.out.println("=== Afficher le plat courant");
//        System.out.println(m1.platCourant());
//        try {
//
//            System.out.println("=== Reculer le plat courant");
//            System.out.println("2.");
//            m1.positionPrecedente();
//            System.out.println("1.");
//            m1.positionPrecedente();
//            System.out.println("0.");
//            m1.positionPrecedente();
//            System.out.println("-1.");
//            m1.positionPrecedente();
//            System.out.println("-2.");
//            m1.positionPrecedente();
//        }
//        catch (MenuException me)
//        {
//            throw me;
//        }
//    }
//
//    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException
//    {
//        System.out.println("===test7_CreerFacture");
//
//        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
//        try
//        {
//            f1.ajoutePlat(platChoisi);
//        }
//        catch (FactureException fe)
//        {
//            throw fe;
//        }
//        System.out.println(f1);
//    }
//
//
//    private void test8_AjouterClientFacture(Facture f1,Client c1) {
//        System.out.println("===test8_AjouterClientFacture");
//        f1.associerClient(c1);
//        System.out.println(f1);
//    }
//    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException,FactureException
//    {
//        System.out.println("===test8_AjouterPlatsFacture");
//
//        try{
//            for (int i=0; i< pos; i++)
//                m1.positionSuivante();
//        }
//        catch (MenuException me)
//        {
//            throw me;
//        }
//
//        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
//        try
//        {
//            f1.ajoutePlat(platChoisi);
//        }
//        catch (FactureException fe)
//        {
//            throw fe;
//        }
//        System.out.println(f1);
//    }
//
//    private void test9_PayerFacture(Facture f1)
//    {
//        System.out.println("===test9_PayerFacture");
//
//        System.out.println("Avant payer la facture");
//        System.out.println(f1);
//        f1.payer();
//        System.out.println("Apres avoir paye la facture");
//        System.out.println(f1);
//    }
//}
