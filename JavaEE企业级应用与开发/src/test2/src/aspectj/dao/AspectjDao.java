package aspectj.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AspectjDao{

    public void save() {
        System.out.println("保存");
    }

    public void modify() {
        System.out.println("修改");
    }

    public void delete() {
        System.out.println("删除");
    }
}
