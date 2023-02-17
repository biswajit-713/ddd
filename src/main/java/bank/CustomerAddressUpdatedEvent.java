package bank;

public class CustomerAddressUpdatedEvent {
    private final Address address;

    public CustomerAddressUpdatedEvent(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
