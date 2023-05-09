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
     *
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
     *
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
     *
     * @return kcal du plat enfant
     */
    public double getKcal() {
        return kcal;
    }

    /**
     *
     * @return chol du plat enfant
     */
    public double getChol() {
        return chol;
    }

    /**
     *
     * @return gras du plat enfant
     */
    public double getGras() {
        return gras;
    }

    /**
     *
     * @param kcal du plat enfant a set
     */
    public void setKcal(double kcal){
        this.kcal = kcal;
    }

    /**
     *
     * @param chol du plat enfant a set
     */
    public void setChol(double chol){
        this.chol = chol;
    }

    /**
     *
     * @param gras du plat a set
     */
    public void setGras(double gras){
        this.gras = gras;
    }
}

