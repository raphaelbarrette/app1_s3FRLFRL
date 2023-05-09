package menufact.plats.etatPlat;

/**
 * class Impossible Servir pour l'etat ImpossibleServir des plats
 */
public class ImpossibleServir implements CommandeEtat{

    /**
     * retourne faux si on essaye de changer d'etat car on ne peut pas changer d'etat quand il est ImpossibleServir
     * @param commandeEtat etat a lequelle changer
     * @return false car aucun changement possible
     */
    public boolean changerEtat(CommandeEtat commandeEtat){
        return false;
    }
}
