

public class chef {
    private chef instance = null;
    private String nom;
    private chef(){}
    public chef getInstance(){
        if (instance == null){
            instance = new chef();
        }
        return instance;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        if(nom == null) {
            this.nom = nom;
        }
    }
    public String toString(){
        return "Chef : " + nom + "\n";
    }
}

