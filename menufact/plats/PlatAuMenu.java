package menufact.plats;
import inventaire.ingredientPlat;
import menufact.plats.exceptions.PlatException;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private ingredientPlat recette;

    public PlatAuMenu(int code, String description, double prix) throws PlatException {
        this.code = code;
        this.description = description;
        if (prix >= 0) {
            this.prix = prix;
        } else {
            throw new PlatException("Impossible : prix negatif");
        }
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getProportion(){
        return 1.0;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setRecette(ingredientPlat recette){
        this.recette = recette;
    }
    public ingredientPlat getRecette(){
        return recette;
    }

}
