package AbstractFactory;

public class SqlServerDepartment implements IDepartment {

    private Department department;

    public SqlServerDepartment(Department department) {
        this.department = department;
    }

    public void insertDepartment() {
        System.out.println("向SqlServer数据库插入一条Department记录");
    }

    public Department getDepartment(int ID) {
        System.out.println("向SqlServer数据库中根据ID取出一条Department记录");
        return department;
    }
}
