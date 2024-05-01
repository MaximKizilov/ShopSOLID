package Model;


import java.util.Objects;

public class Meat {
    private static Form view;
    private String manufacturer;
    private Double price;
    private Integer quantity;
    private Double rating;

    public Meat(String manufacturer, Double price, Integer quantity, Double rating) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Form getView() {
        return view;
    }

    public void setView(Form view) {
        Meat.view = view;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meat meat = (Meat) o;
        return Objects.equals(view, view) && Objects.equals(manufacturer, meat.manufacturer) && Objects.equals(price, meat.price) && Objects.equals(quantity, meat.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, price, quantity, rating);
    }
}
