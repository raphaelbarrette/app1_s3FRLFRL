package menufact.plats.etatPlat;

public class ImpossibleServir implements CommandeEtat{
    //return only false because no state after it
    public boolean changerEtat(CommandeEtat commandeEtat){
        return false;
    }
}
