package domain;

import domain.item.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Product> products;
    private Map<String, Double> competitorProducts = Map.of("apple pencil", 200.00);

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void add(String name) {
        Double competitorPrice = competitorProducts.get(name);
        products.add(new Product(name, new Price(competitorPrice * .9)));
    }
}
