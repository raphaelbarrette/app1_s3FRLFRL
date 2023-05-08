package menufact.facture;

public class FactureEtatPayee implements FactureEtat{
    @Override
    public boolean changerEtat(FactureEtat factureEtat) {
        return false;
    }

    public String toString(){
        return "Facture etat payee";
    }
}
