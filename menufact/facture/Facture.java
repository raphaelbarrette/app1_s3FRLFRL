package menufact.facture;

import ingredients.exceptions.IngredientException;
import menufact.Client;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.chef;
import menufact.plats.exceptions.PlatException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private chef chef;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    public double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    public  double tvq(){
        return TVQ*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer() throws FactureException{
        if (etat.changerEtat(new FactureEtatPayee())){
            etat = new FactureEtatPayee();
        } else {
            throw new FactureException("Facture impossible payer");
        }
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException{
       if (etat.changerEtat(new FactureEtatFermee())){
           etat = new FactureEtatFermee();
       } else {
           throw new FactureException("Facture impossible fermer");
       }
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        if (etat.changerEtat(new FactureEtatOuverte())){
            etat = new FactureEtatOuverte();
        } else {
            throw new FactureException("Facture impossible d'ouvrir");
        }
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new FactureEtatOuverte();
        courant = -1;
        this.description = description;
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        if (etat instanceof FactureEtatOuverte){
            if (p == null){
                throw new PlatException("Impossible d'ajouter un plat nul");
            }
            if (chef == null){
                throw new FactureException("Pas de Chef");
            } else {
                try {
                    chef.cuisiner(p);
                    platchoisi.add(p);
                } catch (IngredientException ingredientException){
                    System.out.println("Pas asser d'ingredient" + ingredientException.getMessage());
                } catch (MenuException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            throw new FactureException("On peut ajouter des plats qu'a une facture ouverte");
        }
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */

    /*
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
    */

    /**
     *
     * @param cuisinier object class chef a associer
     */
    public void observer(chef cuisinier){
        chef = cuisinier;
    }

    /**
     *
     * @return description Facture
     */
    public String getDescription(){
        return description;
    }

    public int getCourant(){
        return courant;
    }

    /**
     *
     * @return client associer a la facture
     */
    public Client getClient(){
        return client;
    }

    /**
     *
     * @return chef associer a la facture
     */
    public chef getChef(){
        return chef;
    }

    /**
     *
     * @return ArrayList de PlatChoisi
     */
    public ArrayList<PlatChoisi> getPlatsChoisis(){
        return platchoisi;
    }

    public Date getDate(){
        return this.date;
    }
}
