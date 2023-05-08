package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.etatPlat.CommandeEtat;
import menufact.plats.exceptions.PlatException;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private CommandeEtat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) throws PlatException{
        this.plat = plat;
        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            throw new PlatException("quantite negative");
        }
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
    public CommandeEtat getEtat(){
        return etat;
    }
    //changes the state in the parameter is the logical next one
    /**
     *
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

