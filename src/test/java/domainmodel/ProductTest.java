package domainmodel;

import domain.Price;
import domain.item.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void productShouldHavePrice() {
        Product applePencil = new Product("apple pencil", new Price(200));

        Assertions.assertEquals(200, applePencil.price());
    }

    @Test
    void shouldPriceProduct10PercentageBelowCompetitorPrice() {
    }
}
