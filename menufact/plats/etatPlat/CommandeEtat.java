package menufact.plats.etatPlat;

/**
 * interface CommandeEtat pour les etat des plats
 */
public interface CommandeEtat {
    /**
     * Verifie s'il est possible de passer d'un etat a un autre
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat);
}
