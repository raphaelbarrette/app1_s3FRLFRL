package menufact.facture;

/**
 * interface pour les Etats de la facture
 */
public interface FactureEtat {
    /**
     * verifie s'il est possible de changer d'un etat a un autre
     * @param factureEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(FactureEtat factureEtat);
}
