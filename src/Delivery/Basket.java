package Delivery;


import Model.Meat;

public interface Basket {


    void addMeatToBasket(Meat meat, int quantity);

    void removeMeatFromBasket(Meat meat, int quantity);

    void displayBasket();
}
