package menufact.facture;

/**
 * class FactureEtatFermee  pour l'etat fermee
 */
public class FactureEtatFermee implements FactureEtat{
    /**
     * verifie s'il est possible de passer de l'etat fermer un autre
     * @param factureEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(FactureEtat factureEtat){
        return factureEtat instanceof FactureEtatPayee || factureEtat instanceof FactureEtatOuverte;
    }

    /**
     * retourne string de l'etat fermer
     * @return String afficher
     */
    public String toString(){
        return "Facture etat fermee";
    }
}
