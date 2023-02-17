package domain;

import java.util.Currency;

public class Price {
    private double value;
    private Currency currency;
    public Price(double value) {
        this.value = value;
        this.currency = Currency.getInstance("USD");
    }


    public double getValue() {
        return value;
    }
}
