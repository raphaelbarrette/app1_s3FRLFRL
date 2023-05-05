package menufact.plats.etatPlat;

public class Commande implements CommandeEtat{
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Preparation;
    }
}
