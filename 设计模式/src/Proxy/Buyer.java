package Proxy;

public class Buyer implements Parcel {

    private Store store;

    public Buyer(Store store) {
        this.store = store;
    }

    @Override
    public String buyBeverage() {
        System.out.println("到[" + store.getName() + "]购买饮料");
        return null;
    }

    @Override
    public void desighatedDriving() {
        System.out.println("从[" + store.getName() + "]请代驾");
    }
}
