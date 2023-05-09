package menufact.facture;

import menufact.Client;
import menufact.exceptions.MenuException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

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
     *
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
     *
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

    public void setDescription(String Description){
        description=Description;
    }

    public void setEtat(FactureEtat Etat){
        etat=Etat;
    }

    public void setPlatchoisi(ArrayList<PlatChoisi> platchoisi) {
        this.platchoisi = platchoisi;
    }
    public void setCourant(int Courant){
        courant=Courant;
    }

    public void setClient(Client Client){
        client=Client;
    }

    public void setTpsPlat(double tpsplat){
        tpsPlat=tpsplat;
    }

    public void setTvqPlat(double tvqplat){
        tvqPlat=tvqplat;
    }

    public void setTotal(double Total){
        total=Total;
    }
}
