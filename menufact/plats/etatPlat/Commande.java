package menufact.plats.etatPlat;

/**
 * class Commande pour l'etat commande des plats
 */
public class Commande implements CommandeEtat{
    /**
     * verifie s'il est possible de changer de l'etat Commande a un autre
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Preparation;
    }
}
