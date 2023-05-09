package menufact.facture;

public class FactureEtatPayee implements FactureEtat{
    /**
     *
     * @param factureEtat etat a lequelle changer
     * @return false car aucun changement possible
     */
    @Override
    public boolean changerEtat(FactureEtat factureEtat) {
        return false;
    }

    /**
     *
     * @return String a afficher
     */
    public String toString(){
        return "Facture etat payee";
    }
}
