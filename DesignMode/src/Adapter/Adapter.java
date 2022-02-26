package Adapter;

public class Adapter extends DutchAddress {

    private Address address;

    public Adapter(Address addr) {
        address = addr;
    }

    public void straat() {
        address.street();
    }

    public void postcode() {
        address.zip();
    }

    public void plaats() {
        address.city();
    }
}
