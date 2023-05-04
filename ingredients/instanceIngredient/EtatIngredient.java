package ingredients.instanceIngredient;

public interface EtatIngredient
{
    public double get_Qty();
    public void set_Qty(double qty);
    public void addQty(Object other);
    public boolean equals(Object other);

}
