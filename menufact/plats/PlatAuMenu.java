package menufact.plats;
import inventaire.ingredientPlat;
import menufact.plats.exceptions.PlatException;

/**
 * class PlatAuMenu pour creer des plats a ajouter au menu
 */
public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private ingredientPlat recette;

    /**
     * constructeur de PlatAuMenu avec le code, la description et le prix
     * @param code du plat
     * @param description du plat
     * @param prix du plat
     * @throws PlatException
     */
    public PlatAuMenu(int code, String description, double prix) throws PlatException {
        this.code = code;
        this.description = description;
        if (prix >= 0) {
            this.prix = prix;
        } else {
            throw new PlatException("Impossible : prix negatif");
        }
    }

    /**
     * constructor sans arguments
     */
    public PlatAuMenu() {
    }

    /**
     * retourne String du plat
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    /**
     * retourne le code du plat
     * @return code du plat
     */
    public int getCode() {
        return code;
    }

    /**
     * set le code du plat
     * @param code du plat
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * retourne la description
     * @return description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     * set lla description du plat
     * @param description du plat a set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * retourne la proportion du plat
     * @return proportion du plat
     */
    public double getProportion(){
        return 1.0;
    }

    /**
     * retourne le prix du plat
     * @return prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     * set le prix du plat
     * @param prix du plat a set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * set la recette du plat
     * @param recette du plat a set
     */
    public void setRecette(ingredientPlat recette){
        this.recette = recette;
    }

    /**
     * retourne la recette du plat
     * @return recette du plat
     */
    public ingredientPlat getRecette(){
        return recette;
    }

}
