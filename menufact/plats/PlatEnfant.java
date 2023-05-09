package menufact.plats;

import menufact.plats.exceptions.PlatException;

/**
 * class PlatEnfant pour les plat enfant
 */
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    /**
     * constructor du platenfant rends la proportion de base a 1.0
     */
    public PlatEnfant() {
        this.proportion = 1.0;
    }

    /**
     *
     * @param code du plat enfant
     * @param description du plat enfant
     * @param prix du plat enfant
     * @param proportion du plat enfant
     * @throws PlatException
     */
    public PlatEnfant(int code, String description, double prix, double proportion) throws PlatException {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     *
     * @return proportion du plat
     */
    public double getProportion() {
        return proportion;
    }

    /**
     *
     * @param proportion du plat a set
     */
    public void setProportion(double proportion){
        this.proportion = proportion;
    }

    /**
     *
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
