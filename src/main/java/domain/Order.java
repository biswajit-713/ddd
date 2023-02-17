package domain;

import domain.item.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public List<Product> products() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

}
