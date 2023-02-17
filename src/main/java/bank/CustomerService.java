package bank;

import java.util.List;

public class CustomerService {


    public void updateAddress(Customer customer, Address newAddress) {
        CustomerAddressUpdatedEvent customerAddressUpdatedEvent = customer.updateAddress(newAddress);
        List<Account> accounts = customer.accounts();
//        accounts.forEach(account -> account.process(customerAddressUpdatedEvent));
    }
}
