package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;

/**
 * class PlatSante pour les plats sante
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * constructeur de PlatSante avec le code, la description, le prix , le kcal, le chol et le gras
     * @param code du plat enfant
     * @param description du plat enfant
     * @param prix du plat enfant
     * @param kcal du plat enfant
     * @param chol du plat enfant
     * @param gras du plat enfant
     * @throws PlatException
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) throws PlatException {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * constructeur sans arguments
     */
    public PlatSante() {
    }

    /**
     * retourne le String du PlatSante
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * retourne kcal du plat enfant
     * @return kcal du plat enfant
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * retourne chol du plat enfant
     * @return chol du plat enfant
     */
    public double getChol() {
        return chol;
    }

    /**
     * retourne gras du plat enfant
     * @return gras du plat enfant
     */
    public double getGras() {
        return gras;
    }

    /**
     * set kcal du plat enfant
     * @param kcal du plat enfant a set
     */
    public void setKcal(double kcal){
        this.kcal = kcal;
    }

    /**
     * set chol du plat enfant
     * @param chol du plat enfant a set
     */
    public void setChol(double chol){
        this.chol = chol;
    }

    /**
     * set gras du plat enfant
     * @param gras du plat a set
     */
    public void setGras(double gras){
        this.gras = gras;
    }
}

