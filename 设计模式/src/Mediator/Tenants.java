package Mediator;

public class Tenants extends Colleague {

    public Tenants(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendRentHouse(message, this);
    }

    @Override
    public void notify(String notify) {
        System.out.println("回复给租客：" + notify);
    }
}
