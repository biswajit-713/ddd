package domain.event;

import domain.item.product.Product;

public class ItemRemovedFromCartEvent implements DomainEvent{
    private final Product product;
    private final int quantity;

    public ItemRemovedFromCartEvent(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
