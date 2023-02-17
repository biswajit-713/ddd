package domain.cart;

import domain.CartStatus;
import domain.Order;
import domain.event.DomainEvent;
import domain.event.ItemAddedToCartEvent;
import domain.event.ItemRemovedFromCartEvent;
import domain.item.Item;
import domain.item.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

import static domain.CartStatus.CHECKED_OUT;
import static domain.CartStatus.IN_PROGRESS;

public class Cart {

    private final UUID id;
    private final List<Item> items;
    private final List<DomainEvent> events;
    private final List<Product> removedProducts;

    private CartStatus status;
    public Cart() {
        items = new ArrayList<>();
        removedProducts = new ArrayList<>();
        events = new ArrayList<>();
        id = UUID.randomUUID();
        status = IN_PROGRESS;
    }

    public void add(Item item) {
        items.add(item);
        events.add(new ItemAddedToCartEvent(item.product(), item.quantity()));
    }


    public boolean has(Product product) {
        return items.stream().anyMatch(item -> item.product().equals(product));
    }

    public void remove(Product product) {
        if(has(product)) {
            Item itemToRemove = items.stream().filter(item -> item.product().equals(product)).toList().get(0);
            items.remove(itemToRemove);
            removedProducts.add(itemToRemove.product());
            events.add(new ItemRemovedFromCartEvent(itemToRemove.product(), itemToRemove.quantity()));
        }
    }

    public List<Product> productsRemoved() {
        return removedProducts;
    }


    public List<DomainEvent> events() {
        return events;
    }

    @Override
    public boolean equals(Object obj) {
        Cart that = (Cart) obj;
        return this.id == that.id;
    }

    public Order checkout() {
        Order order = new Order();
        items.forEach(item -> {
            for(int i=0; i<item.quantity(); i++) {
                order.add(item.product());
            }
        });
        status = CHECKED_OUT;
        return order;
    }
}
