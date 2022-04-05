package AbstractFactory;

public class AccessUser implements IUser {

    private User user;

    public AccessUser(User user) {
        this.user = user;
    }

    public void insertUser() {
        System.out.println("向Access数据库插入一条User记录");
    }

    public User getUser(int ID) {
        System.out.println("向Access数据库中根据ID取出一条User记录");
        return user;
    }
}
