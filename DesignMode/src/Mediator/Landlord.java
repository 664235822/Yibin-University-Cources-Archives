package Mediator;

public class Landlord extends Colleague {

    int nType=0;

    public Landlord(Mediator mediator,int nTyoe) {
        super(mediator);
        this.nType=nTyoe;
    }

    @Override
    public void sendMessage(String message) {
        if (nType == 0) {
            mediator.sendRentHouse(message, this);
        } else {
            mediator.sendBuyHouse(message, this);
        }
    }

    @Override
    public void notify(String notify) {
        System.out.println("回复给房东：" + notify);
    }
}
