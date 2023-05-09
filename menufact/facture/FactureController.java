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
     *
     * @param Modele object facture
     * @param View object View pour afficher
     */
    public FactureController(Facture Modele, FactureView View){
        this.modele=Modele;
        this.view=View;
    }

    /**
     *
     * @param client a associer a la facture
     */
    public void associerClient(Client client){
        modele.associerClient(client);
    }

    /**
     *
     * @return sousTotal de la facture
     */
    public double getSousTotal(){
        return modele.sousTotal();
    }

    /**
     *
     * @return total de la facture
     */
    public double getTotal(){
        return modele.total();
    }

    /**
     *
     * @return tps de la facture
     */
    public double getTps(){
        return modele.tps();
    }

    /**
     *
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
     *
     * @return etat de la facture
     */
    public FactureEtat getEtat(){
        return modele.getEtat();
    }

    /**
     *
     * @param p platChoisi a ajouter a la facture
     * @throws FactureException
     * @throws PlatException
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        modele.ajoutePlat(p);

    }

    /**
     *
     * @param cuisinier
     */
    public void observer(chef cuisinier){
        modele.observer(cuisinier);
    }

    /**
     *
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
     *
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
        return view.genererFacture();
    }
}
