package model;


public  class  Beef extends Meat{
    public Beef(String manufacturer, Double price, Integer quantity, Double rating) {
        super(manufacturer, price, quantity, rating);
        setView(Form.BEEF);
    }


    @Override
    public String toString() {
        return
                "Говядина" +
                ", Производитель= " + getManufacturer() +
                ", Цена= " + getPrice() +
                ", Тара= " + getQuantity() +
                ", Рейтинг= " + getRating();
    }

}
