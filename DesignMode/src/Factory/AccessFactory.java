package Factory;

public class AccessFactory implements IFactory {

    @Override
    public IUser CreateUser(User user) {
        return new AccessUser();
    }
}
