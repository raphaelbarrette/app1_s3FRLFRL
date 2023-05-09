package menufact.plats.etatPlat;

/**
 * class Impossible Servir pour l'etat ImpossibleServir des plats
 */
public class ImpossibleServir implements CommandeEtat{
    //return only false because no state after it

    /**
     *
     * @param commandeEtat etat a lequelle changer
     * @return false car aucun changement possible
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return false;
    }
}
