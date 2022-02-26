package AbstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        // write your code here

        User user = new User();
        Department department = new Department();
        IFactory factory = new AccessFactory();
        IUser iUser = factory.createUser(user);
        iUser.insertUser();
        iUser.getUser(1001);
        IDepartment iDepartment = factory.createDepartment(department);
        iDepartment.insertDepartment();
        iDepartment.getDepartment(1001);
    }
}
