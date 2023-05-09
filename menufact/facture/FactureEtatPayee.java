package menufact.facture;

/**
 * class FactureEtatPayee pour l'etat payee
 */
public class FactureEtatPayee implements FactureEtat{
    /**
     * verifie s'il est possible de changer de l'etat payee a un autre
     * @param factureEtat etat a lequelle changer
     * @return false car aucun changement possible
     */
    @Override
    public boolean changerEtat(FactureEtat factureEtat) {
        return false;
    }

    /**
     * retourne String de letat payee
     * @return String a afficher
     */
    public String toString(){
        return "Facture etat payee";
    }
}
