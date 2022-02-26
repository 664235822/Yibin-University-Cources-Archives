package Factory;

public class SqlServerFactiry implements IFactory {

    @Override
    public IUser CreateUser(User user) {
        return new SqlServerUser();
    }
}
