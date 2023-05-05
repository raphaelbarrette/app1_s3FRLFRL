package menufact.plats.etatPlat;

public class Preparation implements CommandeEtat{
    // returns true if the argument is of class Terminer
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Terminer;
    }
}
