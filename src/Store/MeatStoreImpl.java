package Store;

import Model.Beef;
import Model.Chicken;
import Model.Meat;
import Model.Pork;

import java.util.HashMap;
import java.util.Map;

public class MeatStoreImpl implements MeatStore {
    private static final Map<Meat, Integer> inventory = new HashMap<>();

    static {
        Meat beef = new Beef("БМК", 600.0, 1, 4.0);
        Meat pork = new Pork("Мираторг", 400.0, 1, 4.5);
        Meat chicken = new Chicken("Приосколье", 350.0, 1, 3.0);
        inventory.put(beef, 100);
        inventory.put(pork, 100);
        inventory.put(chicken, 500);
    }

    public static Map<Meat, Integer> getInventory() {
        return inventory;
    }

    @Override
    public void addMeatToReturningAnOrder(Meat meat, int quantity) {
        if (inventory.containsKey(meat)) {
            int existingQuantity = inventory.get(meat);
            int newQuantity = existingQuantity + quantity;
            inventory.put(meat, newQuantity);
        }
    }

    @Override
    public void removeMeatFromInventory(Meat meat, int quantity) {
        if (inventory.containsKey(meat)) {
            int existingQuantity = inventory.get(meat);
            int newQuantity = existingQuantity - quantity;
            if (newQuantity >= 0) {
                inventory.put(meat, newQuantity);
            } else {
                System.out.println("Отрицательное количество товара недопустимо");
            }
        }
    }

    @Override
    public void displayInventory() {
        for (Map.Entry<Meat, Integer> entry : inventory.entrySet()) {
            Meat meat = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("На складе: " + meat + ", в количестве: " + quantity);
        }
    }
}