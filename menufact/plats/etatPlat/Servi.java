package menufact.plats.etatPlat;

public class Servi implements CommandeEtat{
    //returns false because it is the last state possible
    public boolean changerEtat(CommandeEtat commandeEtat){
        return false;
    }
}
