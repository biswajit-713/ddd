package domain.item.product;

import domain.Price;

public class Product {
    private final String name;
    private final Price price;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public double price() {
        return price.getValue();
    }
}
