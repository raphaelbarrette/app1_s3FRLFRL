package menufact.plats.etatPlat;

public interface CommandeEtat {
    /**
     *
     * @param commandeEtat etat a lequelle changer
     * @return true si changement possible, false sinon
     */
    public boolean changerEtat(CommandeEtat commandeEtat);
}
