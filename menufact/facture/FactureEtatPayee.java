package menufact.facture;

public class FactureEtatPayee implements FactureEtat{
    @Override
    public boolean changerEtat(FactureEtat factureEtat) {
        return false;
    }
}
