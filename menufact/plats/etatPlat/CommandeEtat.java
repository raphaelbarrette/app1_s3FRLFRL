package menufact.plats.etatPlat;

/**
 * interface CommandeEtat pour les etat des plats
 */
public interface CommandeEtat {
    /**
     *
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat);
}
