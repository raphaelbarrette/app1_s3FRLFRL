package menufact.plats;

import menufact.plats.PlatAuMenu;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    public PlatSante() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }

    public void setKcal(double kcal){
        this.kcal = kcal;
    }
    public void setChol(double chol){
        this.chol = chol;
    }
    public void setGras(double gras){
        this.gras = gras;
    }
}

