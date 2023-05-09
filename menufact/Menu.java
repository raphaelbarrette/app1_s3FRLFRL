package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;

import java.util.ArrayList;

/**
 * class Menu pour le menu ou on rajoute les plats
 */
public class Menu {
    private static Menu instance = null;
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    /**\
     * private constructor pour singleton avec la description
     * @param description du menu
     */
    private Menu(String description) {
        this.description = description;
    }

    /**
     * cree object menu si aucun existe sinon retourne celui qui existe
     * @param description du menu
     * @return object de menu
     */
    public static Menu getInstance(String description){
        if (instance == null){
            instance = new Menu(description);
        }
        return instance;
    }

    /**
     * ajoute un plat au menu
     * @param p plat a ajouter
     * @throws PlatException si plat est null
     */
    void ajoute (PlatAuMenu p) throws PlatException
    {
        if (p == null){
            throw new PlatException("Impossible d'ajouter plat null");
        }
        plat.add(p);
    }

    /**
     * retourne la description du menu
     * @return description de menu
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * set la description du menu
     * @param description du menu
     * @throws PlatException si description est null
     */
    public void setDescription(String description) throws PlatException{
        if (description != null){
            this.description = description;
        } else {
            throw new PlatException("Impossible d'ajouter description null");
        }
    }

    /**
     * change l'index courant a un specifique
     * @param i index de la position
     */
    public void position(int i)
    {
        courant = i;
    }

    /**
     * retourne le plat a l'index courant
     * @return plat a l'index courant
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /**
     * bouge d'une position dans les plats de la facture
     * @throws MenuException si on depasse le nombre maximal de plat
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * bouge d'une position dans les plats de la facture
     * @throws MenuException si on depasse le nombre minimale de plats
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * retourne la taille du menu
     * @return taille l'ArrayList de plat dans le menu
     */
    public double getSize(){
        return plat.size();
    }

    /**
     * vide ArrayList
     */
    public void clear(){
        plat.clear();
    }

    /**
     * retourne String du menu
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
