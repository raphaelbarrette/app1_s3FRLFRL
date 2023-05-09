package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.etatPlat.CommandeEtat;
import menufact.plats.exceptions.PlatException;

/**
 * class PlatChoisi pour les plat choisi a ajouter au menu
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private CommandeEtat etat;

    /**
     * constructeur de PlatChoisi avec plat et quantite
     * @param plat a mettre comme plat choisi
     * @param quantite quantite du plat a ajouter
     * @throws PlatException
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) throws PlatException{
        this.plat = plat;
        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            throw new PlatException("quantite negative");
        }
    }

    /**
     * retourne String du PlatChoisi
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    /**
     * retourne la quantite du PlatChoisi
     * @return quantite du plat
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * set la quantite du PlatChoisi
     * @param quantite du plat a set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * retourne le PlatChoisi
     * @return plat
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /**
     * retourne l'etat du PlatChoisi
     * @return etat du plat
     */
    public CommandeEtat getEtat(){
        return etat;
    }
    //changes the state in the parameter is the logical next one
    /**
     * set l'etat du PlatChoisi
     * @param etat2 state to change to
     */
    public void setEtat(CommandeEtat etat2){
        if (etat == null){
            this.etat = etat2;
        } else if (etat.changerEtat(etat2)) {
            this.etat = etat2;
        } else {
            //throw exception
        }

    }

}

