package Store;

import model.Meat;

public interface MeatStore {
    public void addMeatToReturningAnOrder(Meat meat, int quantity);
    public void removeMeatFromInventory(Meat meat, int quantity);
    public void displayInventory();
}
