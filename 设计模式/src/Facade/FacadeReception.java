package Facade;

public class FacadeReception {

    public void reception(){
        Restaurant restaurant=new Restaurant();
        restaurant.acceptInvestment();
        //restaurant.SPA();

        Entertainment entertainment=new Entertainment();
        entertainment.acceptInvestment();
    }
}
