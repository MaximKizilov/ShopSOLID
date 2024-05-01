package Store;

import Model.Meat;

public interface MeatStore {
    void addMeatToReturningAnOrder(Meat meat, int quantity);

    void removeMeatFromInventory(Meat meat, int quantity);

    void displayInventory();
}
