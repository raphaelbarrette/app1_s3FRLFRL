package menufact.plats;

public class BuilderPlatEnfant extends BuilderPlat{
    /**
     * constructor de PlatEnfant
     */
    public BuilderPlatEnfant(){
        plat = new PlatEnfant();
    }

    /**
     *
     * @param proportion du plat a build
     */
    public void build_proportion(double proportion){
        ((PlatEnfant) plat).setProportion(proportion);
    }

    /**
     *
     * @return plat
     */
    public PlatEnfant getPlat(){
        return (PlatEnfant) plat;
    }

    /**
     * remplace le plat par un autre
     */
    public void clear(){
        plat = new PlatEnfant();
    }

}
