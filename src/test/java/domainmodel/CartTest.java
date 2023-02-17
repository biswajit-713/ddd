package domainmodel;

import domain.Order;
import domain.Price;
import domain.cart.Cart;
import domain.event.DomainEvent;
import domain.item.Item;
import org.junit.jupiter.api.Test;
import domain.item.product.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void shouldBeAbleToAddProductToCartWhenCartIsEmpty() {
        Price price = new Price(200);
        Product applePencil = new Product("apple pencil", price);

        Cart cart = new Cart();

        Item item = new Item(applePencil, 2);
        cart.add(item);

        assertTrue(cart.has(applePencil));
    }

    @Test
    void shouldBeAbleToAddProductToCartWhenCartHasOtherItems() {
        Price price = new Price(200);
        Product applePencil = new Product("apple pencil", price);
        Product sonyWirelessHeadphone = new Product("sony wireless headphone", price);
        Cart cart = new Cart();
        cart.add(new Item(applePencil, 1));

        cart.add(new Item(sonyWirelessHeadphone, 1));

        assertTrue(cart.has(sonyWirelessHeadphone));
    }

    @Test
    void shouldBeAbleToRemoveItemAddedToCart(){

        Price price = new Price(200);
        Product applePencil = new Product("apple pencil", price);

        Cart cart = new Cart();

        Item item = new Item(applePencil, 2);
        cart.add(item);
        cart.remove(applePencil);

        assertFalse(cart.has(applePencil));
    }

    @Test
    void shouldBeAbleToGetAllProductsThoseWereRemovedFromCart() {
        Price price = new Price(200);
        Product applePencil = new Product("apple pencil", price);
        Product sonyHeadphone = new Product("sony headphone", price);
        Product sonySpeaker = new Product("sony speaker", price);

        Cart cart = new Cart();

        Item pencil = new Item(applePencil, 2);
        cart.add(pencil);
        Item headphone = new Item(sonyHeadphone, 1);
        cart.add(headphone);
        Item speaker = new Item(sonySpeaker, 1);
        cart.add(speaker);

        cart.remove(applePencil);
        cart.remove(sonyHeadphone);

        List<Product> productsRemoved = cart.productsRemoved();
        assertTrue(productsRemoved.contains(applePencil));
        assertTrue(productsRemoved.contains(sonyHeadphone));

        List<DomainEvent> events = cart.events();

    }

    @Test
    void shouldConsiderTwoCartsAsDifferentEvenAsThoseHaveSameItems() {
        Price price = new Price(200);
        Item snehasItem = new Item(new Product("apple pencil", price), 1);
        Item biswajitsItem = new Item(new Product("apple pencil", price), 1);

        Cart snehasCart = new Cart();
        snehasCart.add(snehasItem);
        Cart biswajitsCart = new Cart();
        biswajitsCart.add(biswajitsItem);

        assertNotEquals(snehasCart, biswajitsCart);

    }

    @Test
    void shouldCreateOrderWhenTheCartIsCheckedout() {
        Cart cart = new Cart();
        Product applePencil = new Product("apple pencil", new Price(100));
        cart.add(new Item(applePencil, 2));

        Order newOrder = cart.checkout();
        List<Product> products = newOrder.products();

        assertEquals(applePencil, products.get(0));
        assertEquals(applePencil, products.get(1));
        assertEquals(2, products.size());
    }
}
