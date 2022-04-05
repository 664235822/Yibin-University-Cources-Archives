package AbstractFactory;

public interface IFactory {

    IUser createUser(User user);

    IDepartment createDepartment(Department department);
}
