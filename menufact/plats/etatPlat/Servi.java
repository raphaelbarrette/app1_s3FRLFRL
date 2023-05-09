package menufact.plats.etatPlat;

/**
 * class Servi pour l'etat Servi des plats
 */
public class Servi implements CommandeEtat{
    /**
     * verifie s'il est possible de changer de l'etat Servi a un autre
     * @param commandeEtat etat a lequelle changer
     * @return true si possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return false;
    }
}
