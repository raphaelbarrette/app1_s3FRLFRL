package menufact.facture;

public interface FactureEtat {
    /**
     *
     * @param factureEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(FactureEtat factureEtat);
}
