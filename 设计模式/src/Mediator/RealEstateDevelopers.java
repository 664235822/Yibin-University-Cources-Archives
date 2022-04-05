package Mediator;

public class RealEstateDevelopers extends Colleague {

    public RealEstateDevelopers(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendBuyHouse(message, this);
    }

    @Override
    public void notify(String notify) {
        System.out.println("回复给开发商：" + notify);
    }
}
