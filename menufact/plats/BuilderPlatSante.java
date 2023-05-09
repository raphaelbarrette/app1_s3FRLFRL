package menufact.plats;


/**
 * class BuilderPlatSante pour le builder des plats
 */
public class BuilderPlatSante extends BuilderPlat{
    /**
     * constructor de plat sante
     */
    public BuilderPlatSante(){
        plat = new PlatSante();
    }

    /**
     * set le kcal du plat sante
     * @param kcal du plat a build
     */
    public void build_kcal(double kcal){
        ((PlatSante) plat).setKcal(kcal);
    }

    /**
     * set le chol du plat sante
     * @param chol du plat a build
     */
    public void build_chol(double chol){
        ((PlatSante) plat).setChol(chol);
    }

    /**
     * set le gras d'un plat sante
     * @param gras du plat a build
     */
    public void build_gras(double gras){
        ((PlatSante) plat).setGras(gras);
    }

    /**
     * remplace le plat un autre vide
     */
    public void clear(){
        plat = new PlatSante();
    }

    /**
     * retourne le plat sante
     * @return plat sante
     */
    public PlatSante getPlat(){
        return (PlatSante)plat;
    }

}
