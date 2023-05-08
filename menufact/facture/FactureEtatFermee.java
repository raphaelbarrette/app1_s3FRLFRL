package menufact.facture;

public class FactureEtatFermee implements FactureEtat{
    public boolean changerEtat(FactureEtat factureEtat){
        return factureEtat instanceof FactureEtatPayee || factureEtat instanceof FactureEtatOuverte;
    }
}
