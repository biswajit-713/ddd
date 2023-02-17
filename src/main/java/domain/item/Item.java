package domain.item;

import domain.item.product.Product;

public class Item {
    private final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }
}
