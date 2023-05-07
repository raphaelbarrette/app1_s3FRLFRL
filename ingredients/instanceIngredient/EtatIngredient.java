package ingredients.instanceIngredient;

import ingredients.exceptions.IngredientException;

public interface EtatIngredient
{
    public double get_Qty();
    public void set_Qty(double qty) throws IngredientException;
    public void addQty(Object other);
    public boolean equals(Object other);
    public String getEtat();
    public String toString();

}