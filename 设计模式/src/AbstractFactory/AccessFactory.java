package AbstractFactory;

public class AccessFactory implements IFactory {

    public IUser createUser(User user) {
        return new AccessUser(user);
    }

    public IDepartment createDepartment(Department department) {
        return new AccessDepartment(department);
    }
}
