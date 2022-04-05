package Proxy;

public class Proxy implements Parcel{

    private Buyer buyer;

    public Proxy(Store store){
        buyer=new Buyer(store);
    }

    @Override
    public String buyBeverage() {
        buyer.buyBeverage();
        return null;
    }

    @Override
    public void desighatedDriving() {
        buyer.desighatedDriving();
    }
}
