package menufact.facture;

import menufact.Client;
import menufact.exceptions.MenuException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * class FActureView pour le View du MVC de facture
 */
public class FactureView {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi= new ArrayList<>();
    private int courant;
    private Client client;
    private final double TPS= 0.05;
    private final double TVQ=0.095;
    private double total;
    private double tpsPlat;
    private double tvqPlat;

    /**
     * retourne String de la facture
     * @return String a afficher
     */
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
     * retourne String de la facture generer
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture() throws MenuException
    {
        if (!(etat instanceof FactureEtatPayee)){
            throw new MenuException("Facture non payee");
        }
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

        factureGenere += "          TPS:               " + tpsPlat + "\n";
        factureGenere += "          TVQ:               " + tvqPlat + "\n";
        factureGenere += "          Le total est de:   " + total+ "\n";

        return factureGenere;
    }

    /**
     * set la date de la facture
     * @param date de la facture
     */
    public void setDate(Date date){this.date = date;}

    /**
     * set la description de la facture
     * @param Description de la facture
     */
    public void setDescription(String Description){
        description=Description;
    }

    /**
     * retourne l'etat de la facture
     * @param Etat de la facture
     */
    public void setEtat(FactureEtat Etat){
        etat=Etat;
    }

    /**
     * set l'ArrayList de platChoisi de la facture
     * @param platchoisi de la facture
     */
    public void setPlatchoisi(ArrayList<PlatChoisi> platchoisi) {
        this.platchoisi = platchoisi;
    }

    /**
     * set le courant de la facture
     * @param Courant de la facture
     */
    public void setCourant(int Courant){
        courant=Courant;
    }

    /**
     * set le client associe a la facture
     * @param Client de la facture
     */
    public void setClient(Client Client){
        client=Client;
    }

    /**
     * set le tps d'un plat de la facture
     * @param tpsplat de la facture
     */
    public void setTpsPlat(double tpsplat){
        tpsPlat=tpsplat;
    }

    /**
     * set le tvp d'un plat de la facture
     * @param tvqplat de la facture
     */
    public void setTvqPlat(double tvqplat){
        tvqPlat=tvqplat;
    }

    /**
     * set le total de la facture
     * @param Total de la facture
     */
    public void setTotal(double Total){
        total=Total;
    }
}
