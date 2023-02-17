package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CustomerTest {
    @Test
    public void shouldUpdateAccountAddressWhenCustomerAddressIsChanged() {
        Address hyderabad = new Address("hyderabad");
        Address bangalore = new Address("hyderabad");
        List<Account> accounts = Arrays.asList(new Account(hyderabad), new Account(bangalore));
        Customer customer = new Customer(hyderabad, accounts);

        Address mumbai = new Address("mumbai");
        CustomerService customerService = new CustomerService();
        customerService.updateAddress(customer, mumbai);

        List<Address> addresses = customer.accounts().stream().map(Account::address).toList();
        Assertions.assertEquals(mumbai, addresses.get(0));
        Assertions.assertEquals(mumbai, addresses.get(1));
    }
}
