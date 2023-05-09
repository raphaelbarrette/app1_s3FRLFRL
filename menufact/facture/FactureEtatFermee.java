package menufact.facture;

public class FactureEtatFermee implements FactureEtat{
    /**
     *
     * @param factureEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(FactureEtat factureEtat){
        return factureEtat instanceof FactureEtatPayee || factureEtat instanceof FactureEtatOuverte;
    }

    /**
     *
     * @return String afficher
     */
    public String toString(){
        return "Facture etat fermee";
    }
}
