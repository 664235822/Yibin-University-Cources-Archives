package AbstractFactory;

public class AccessDepartment implements IDepartment {

    private Department department;

    public AccessDepartment(Department department) {
        this.department = department;
    }

    public void insertDepartment() {
        System.out.println("向Access数据库插入一条Department记录");
    }

    public Department getDepartment(int ID) {
        System.out.println("向Access数据库中根据ID取出一条Department记录");
        return department;
    }
}
