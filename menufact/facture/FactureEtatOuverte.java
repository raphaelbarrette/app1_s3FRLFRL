package menufact.facture;

public class FactureEtatOuverte implements FactureEtat{
    public boolean changerEtat(FactureEtat factureEtat){
        return factureEtat instanceof FactureEtatFermee || factureEtat instanceof FactureEtatPayee;
    }
}
