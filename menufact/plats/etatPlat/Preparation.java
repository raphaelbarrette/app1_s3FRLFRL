package menufact.plats.etatPlat;

/**
 * class Preparation pour l'etat Preparation des plats
 */
public class Preparation implements CommandeEtat{
    /**
     * verifie s'il est possible de changer de l'etat Preparation a un autre
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Terminer;
    }
}
