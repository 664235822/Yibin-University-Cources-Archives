package Mediator;

public class RealEstateAgents extends Mediator {

    private Tenants tenants;

    private Landlord landlord;

    private RealEstateDevelopers estateDevelopers;

    public void setTenants(Tenants tenants) {
        this.tenants = tenants;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setEstateDevelopers(RealEstateDevelopers estateDevelopers) {
        this.estateDevelopers = estateDevelopers;
    }

    @Override
    public void sendRentHouse(String message, Colleague colleague) {
        if (colleague instanceof Tenants) {
            landlord.notify(message);
        } else {
            tenants.notify(message);
        }
    }

    @Override
    public void sendBuyHouse(String message, Colleague colleague) {
        if (colleague instanceof RealEstateDevelopers) {
            landlord.notify(message);
        } else {
            estateDevelopers.notify(message);
        }
    }
}
