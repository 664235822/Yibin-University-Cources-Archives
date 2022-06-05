package aspectj.dao;

import org.springframework.stereotype.Repository;

@Repository("testDao")
public class TestDao {

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
