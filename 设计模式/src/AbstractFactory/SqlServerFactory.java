package AbstractFactory;

public class SqlServerFactory implements IFactory {

    public IUser createUser(User user) {
        return new SqlServerUser(user);
    }

    public IDepartment createDepartment(Department department) {
        return new SqlServerDepartment(department);
    }
}
