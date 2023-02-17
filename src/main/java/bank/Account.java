package bank;

import java.util.UUID;

public class Account {
    private final UUID uuid;
    private Address address;

    public Account(Address address) {
        uuid = UUID.randomUUID();
        this.address = address;
    }

    public void process(CustomerAddressUpdatedEvent customerAddressUpdatedEvent) {
        this.address = customerAddressUpdatedEvent.getAddress();
    }

    public Address address() {
        return address;
    }

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }
}
