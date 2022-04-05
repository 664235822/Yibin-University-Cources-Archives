package Factory;

public class SqlServerUser implements IUser {

    public void insertUser() {
        System.out.println("向SqlServer数据库插入一条User记录");
    }

    public User getUser(int ID) {
        System.out.println("向SqlServer数据库中根据ID取出一条User记录");
        return null;
    }
}
