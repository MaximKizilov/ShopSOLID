package Model;

public class Pork extends Meat {
    public Pork(String manufacturer, Double price, Integer quantity, Double rating) {
        super(manufacturer, price, quantity, rating);
        setView(Form.PORK);

    }

    @Override
    public String toString() {
        return
                "Свинина" +
                        ", Производитель= " + getManufacturer() +
                        ", Цена= " + getPrice() +
                        ", Тара= " + getQuantity() +
                        ", Рейтинг= " + getRating();
    }
}
