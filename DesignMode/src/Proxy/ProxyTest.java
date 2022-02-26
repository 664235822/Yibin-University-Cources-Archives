package Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // write your code here

        Store store=new Store();
        store.setName("天猫国际");

        Proxy proxy=new Proxy(store);
        proxy.buyBeverage();
        proxy.desighatedDriving();
    }
}
