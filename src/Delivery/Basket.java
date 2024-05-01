package Delivery;

import model.Meat;

public interface Basket {

    public void addMeatToBasket(Meat meat, int quantity);
    public void removeMeatFromBasket(Meat meat, int quantity);
    public void displayBasket();

}
