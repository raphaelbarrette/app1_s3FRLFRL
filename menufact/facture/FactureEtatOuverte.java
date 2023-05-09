package menufact.facture;

/**
 * class FactureEtatOuverte pour l'etat ouvert
 */
public class FactureEtatOuverte implements FactureEtat{
    /**
     *
     * @param factureEtat etat a lequelle changer
     * @return true si possible, false sinon
     */
    public boolean changerEtat(FactureEtat factureEtat){
        return factureEtat instanceof FactureEtatFermee || factureEtat instanceof FactureEtatPayee;
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Facture etat ouverte";
    }
}


