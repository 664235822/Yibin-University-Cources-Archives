package Factory;

public class AccessUser implements IUser {

    public void insertUser() {
        System.out.println("向Access数据库插入一条User记录");
    }

    public User getUser(int ID) {
        System.out.println("向Access数据库中根据ID取出一条User记录");
        return null;
    }
}
