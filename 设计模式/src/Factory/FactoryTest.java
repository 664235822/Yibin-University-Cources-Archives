package Factory;

public class FactoryTest {
    public static void main(String[] args) {
        // write your code here

        User user = new User();
        IFactory factory = new AccessFactory();
        IUser iUser = factory.CreateUser(user);
        iUser.insertUser();
        iUser.getUser(1001);
    }
}
