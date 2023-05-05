package menufact.plats;

public class BuilderPlatEnfant extends BuilderPlat{
    public BuilderPlatEnfant(){
        plat = new PlatEnfant();
    }
    public void build_proportion(double proportion){
        ((PlatEnfant) plat).setProportion(proportion);
    }
    public PlatEnfant getPlat(){
        return (PlatEnfant) plat;
    }
    public void clear(){
        plat = new PlatEnfant();
    }

}
