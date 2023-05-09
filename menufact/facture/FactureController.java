package menufact.facture;

import menufact.chef;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import menufact.Client;

/**
 * controller du MVC de la facture
 */
public class FactureController {
    private Facture modele;
    private FactureView view;

    /**
     *constructeur de FactureController avec le modele et le view
     * @param Modele object facture
     * @param View object View pour afficher
     */
    public FactureController(Facture Modele, FactureView View){
        this.modele=Modele;
        this.view=View;
    }

    /**
     * associe un client a la facture
     * @param client a associer a la facture
     */
    public void associerClient(Client client){
        modele.associerClient(client);
    }

    /**
     * retourne le sousTotal de la facture
     * @return sousTotal de la facture
     */
    public double getSousTotal(){
        return modele.sousTotal();
    }

    /**
     * retourne le total de la facture
     * @return total de la facture
     */
    public double getTotal(){
        return modele.total();
    }

    /**
     * retourne le tps de la facture
     * @return tps de la facture
     */
    public double getTps(){
        return modele.tps();
    }

    /**
     * retourne le tvq de la facture
     * @return tvq de la facture
     */
    public double getTvq(){
        return modele.tvq();
    }

    /**
     * paye la facture
     * @throws FactureException
     */
    public void payer() throws FactureException{
        modele.payer();
    }

    /**
     * ferme la facture
     * @throws FactureException
     */
    public void fermer() throws FactureException{
        modele.fermer();
    }

    /**
     * ouvre la facture
     * @throws FactureException
     */
    public void ouvrir() throws FactureException{
        modele.ouvrir();
    }

    /**
     * retourne l'etat de la facture
     * @return etat de la facture
     */
    public FactureEtat getEtat(){
        return modele.getEtat();
    }

    /**
     * ajoute un plat a la facture
     * @param p platChoisi a ajouter a la facture
     * @throws FactureException
     * @throws PlatException
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        modele.ajoutePlat(p);

    }

    /**
     * associe un chef a la facture
     * @param cuisinier
     */
    public void observer(chef cuisinier){
        modele.observer(cuisinier);
    }

    /**
     * Donne les informations a view
     * @return String a afficher
     */
    public String afficheFacture(){
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatsChoisis());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        view.setDate(modele.getDate());
        return view.toString();

    }

    /**
     * donne les informations a view
     * @return String a afficher
     * @throws MenuException
     */
    public String genereFacture() throws MenuException {
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatsChoisis());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        view.setTpsPlat(modele.tps());
        view.setTvqPlat(modele.tvq());
        view.setTotal(modele.total());
        view.setDate(modele.getDate());
        return view.genererFacture();
    }
}
