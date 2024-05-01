package Delivery;

import Model.Meat;
import Store.MeatStore;

import java.util.HashMap;
import java.util.Map;

public class BasketImpl implements Basket {
    private final Map<Meat, Integer> basket;
    private final MeatStore meatStore;

    public BasketImpl(MeatStore meatStore) {
        this.basket = new HashMap<>();
        this.meatStore = meatStore;
    }


    public Map<Meat, Integer> getBasket() {
        return basket;
    }

    @Override
    public void addMeatToBasket(Meat meat, int quantity) {
        if (meatStore != null) {
            if (basket.containsKey(meat)) {
                int existingQuantity = basket.get(meat);
                basket.put(meat, existingQuantity + quantity);
            } else {
                basket.put(meat, quantity);
            }
            meatStore.removeMeatFromInventory(meat, quantity);
        }
    }

    @Override
    public void removeMeatFromBasket(Meat meat, int quantity) {
        if (basket.containsKey(meat)) {
            int existingQuantity = basket.get(meat);
            int newQuantity = existingQuantity - quantity;
            if (newQuantity > 0) {
                basket.put(meat, newQuantity);
            } else {
                basket.remove(meat);
            }
            meatStore.addMeatToReturningAnOrder(meat, quantity);
        }
    }

    @Override
    public void displayBasket() {
        for (Map.Entry<Meat, Integer> entry : basket.entrySet()) {
            Meat meat = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("В корзине " + meat + ", в количестве:  " + quantity);
        }
    }
}
