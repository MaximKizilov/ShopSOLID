package Model;

public class Chicken extends Meat {
    public Chicken(String manufacturer, Double price, Integer quantity, Double rating) {
        super(manufacturer, price, quantity, rating);
        setView(Form.CHICKEN);
    }

    @Override
    public String toString() {
        return
                "Курица" +
                        ", Производитель= " + getManufacturer() +
                        ", Цена= " + getPrice() +
                        ", Тара= " + getQuantity() +
                        ", Рейтинг= " + getRating();
    }
}
