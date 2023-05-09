package menufact.plats.etatPlat;

/**
 * class Terminer pour l'etat Terminer des plats
 */
public class Terminer implements CommandeEtat{
    /**
     * verifie s'il est possible de changer de l'etat Terminer a un autre
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Servi;

    }
}
