package Mediator;

public class MediatorTest {

    public static void main(String[] args) {
        // write your code here

        RealEstateAgents realEstateAgents=new RealEstateAgents();
        Tenants tenants=new Tenants(realEstateAgents);
        Landlord landlord=new Landlord(realEstateAgents,0);

        realEstateAgents.setTenants(tenants);
        realEstateAgents.setLandlord(landlord);

        tenants.sendMessage("租一套房子");
        landlord.sendMessage("目前没有房源");

        RealEstateAgents realEstateAgents2=new RealEstateAgents();
        RealEstateDevelopers realEstateDevelopers=new RealEstateDevelopers(realEstateAgents2);
        Landlord landlord2=new Landlord(realEstateAgents2,1);

        realEstateAgents2.setLandlord(landlord2);
        realEstateAgents2.setEstateDevelopers(realEstateDevelopers);

        landlord2.sendMessage("买一套房子");
        realEstateDevelopers.sendMessage("目前有房源");
    }
}
