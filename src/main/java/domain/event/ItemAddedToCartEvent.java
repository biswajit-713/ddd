package domain.event;

import domain.item.product.Product;

public class ItemAddedToCartEvent implements DomainEvent{
    private final Product product;
    private final int quantity;

    public ItemAddedToCartEvent(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
