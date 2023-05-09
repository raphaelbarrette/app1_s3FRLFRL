package menufact.plats.etatPlat;

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
