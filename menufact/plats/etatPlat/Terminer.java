package menufact.plats.etatPlat;

public class Terminer implements CommandeEtat{
    //returns true if the argument is an object of class Servi
    //which is the next state in line
    public boolean changerEtat(CommandeEtat commandeEtat){
        return commandeEtat instanceof Servi;

    }
}
