package menufact.plats;



public class BuilderPlatSante extends BuilderPlat{
    public BuilderPlatSante(){
        plat = new PlatSante();
    }
    public void build_kcal(double kcal){
        ((PlatSante) plat).setKcal(kcal);
    }
    public void build_chol(double chol){
        ((PlatSante) plat).setChol(chol);
    }
    public void build_gras(double gras){
        ((PlatSante) plat).setGras(gras);
    }
    public void clear(){
        plat = new PlatSante();
    }
    public PlatSante getPlat(){
        return (PlatSante)plat;
    }

}
