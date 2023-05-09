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
     *
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
     *
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
     *
     * @return code du plat
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code du plat
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description du plat a set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return proportion du plat
     */
    public double getProportion(){
        return 1.0;
    }

    /**
     *
     * @return prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     *
     * @param prix du plat a set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     *
     * @param recette du plat a set
     */
    public void setRecette(ingredientPlat recette){
        this.recette = recette;
    }

    /**
     *
     * @return recette du plat
     */
    public ingredientPlat getRecette(){
        return recette;
    }

}
