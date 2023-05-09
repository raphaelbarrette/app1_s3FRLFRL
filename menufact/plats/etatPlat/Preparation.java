package menufact.plats.etatPlat;

/**
 * class Preparation pour l'etat Preparation des plats
 */
public class Preparation implements CommandeEtat{
    /**
     *
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Terminer;
    }
}
