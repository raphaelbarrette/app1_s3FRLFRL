package menufact.plats;

/**
 * class BuilderPlatEnfant pour le builder des plats
 */
public class BuilderPlatEnfant extends BuilderPlat{
    /**
     * constructor de PlatEnfant
     */
    public BuilderPlatEnfant(){
        plat = new PlatEnfant();
    }

    /**
     * set la proportion d'un plat enfant
     * @param proportion du plat a build
     */
    public void build_proportion(double proportion){
        ((PlatEnfant) plat).setProportion(proportion);
    }

    /**
     * retourne le plat enfant
     * @return plat
     */
    public PlatEnfant getPlat(){
        return (PlatEnfant) plat;
    }

    /**
     * remplace le plat par un autre nouveau vide
     */
    public void clear(){
        plat = new PlatEnfant();
    }

}
