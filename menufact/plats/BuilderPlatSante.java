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
     *
     * @param kcal du plat a build
     */
    public void build_kcal(double kcal){
        ((PlatSante) plat).setKcal(kcal);
    }

    /**
     *
     * @param chol du plat a build
     */
    public void build_chol(double chol){
        ((PlatSante) plat).setChol(chol);
    }

    /**
     *
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
     *
     * @return plat sante
     */
    public PlatSante getPlat(){
        return (PlatSante)plat;
    }

}
