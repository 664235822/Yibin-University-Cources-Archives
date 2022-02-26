package Adapter;

public class AdapterTest {
    public static void main(String[] args) {
        // write your code here

        Address address = new Address();
        DutchAddress dutchAddress = new Adapter(address);
        dutchAddress.straat();
        dutchAddress.postcode();
        dutchAddress.plaats();
    }
}
