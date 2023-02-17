package bank;

import java.util.List;
import java.util.UUID;

public class Customer {

    private final UUID uuid;
    private Address address;
    private List<Account> accounts;
    private AddressObserver observer;

    public Customer(Address address, List<Account> accounts) {
        this.uuid = UUID.randomUUID();
        this.address = address;
        this.accounts = accounts;
        observer = new AddressObserver();
    }

    public CustomerAddressUpdatedEvent updateAddress(Address newAddress) {
        this.address = newAddress;
//        send CustomerAddressUpdatedEvent
//        Account
        accounts.forEach(account -> observer.updateAddress(account, newAddress));

        return new CustomerAddressUpdatedEvent(newAddress);
    }


    public List<Account> accounts() {
        return accounts;
    }

}
