package menufact.facture;

import menufact.chef;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import menufact.Client;


public class FactureController {
    private Facture modele;
    private FactureView view;

    public FactureController(Facture Modele, FactureView View){
        this.modele=Modele;
        this.view=View;
    }

    public void associerClient(Client client){
        modele.associerClient(client);
    }



    public double getSousTotal(){
        return modele.sousTotal();
    }

    public double getTotal(){
        return modele.total();
    }

    //peut etre besoin


    public double getTps(){
        return modele.tps();
    }

    public double getTvq(){
        return modele.tvq();
    }

    public void payer() throws FactureException{
        modele.payer();
    }

    public void fermer() throws FactureException{
        modele.fermer();
    }

    public void ouvrir() throws FactureException{
        modele.ouvrir();
    }

    public FactureEtat getEtat(){
        return modele.getEtat();
    }

    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        modele.ajoutePlat(p);

    }

    public void observer(chef cuisinier){
        modele.observer(cuisinier);
    }

    public String afficheFacture(){
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatChoisi());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        return view.toString();

    }

    public String genereFacture() throws MenuException {
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatChoisi());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        view.setTpsPlat(modele.tps());
        view.setTvqPlat(modele.tvq());
        view.setTotal(modele.total());
        return view.genererFacture();
    }





}
