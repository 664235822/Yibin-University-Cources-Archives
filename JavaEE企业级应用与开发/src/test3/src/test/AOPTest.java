import aspectj.config.AspectjAOPConfig;
import aspectj.dao.TestDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void aopTest() {
        //初始化Spring容器ApplicationContext
        AnnotationConfigApplicationContext appCon =
                new AnnotationConfigApplicationContext(AspectjAOPConfig.class);
        //从容器中获取增强后的目标对象
        TestDao testDaoAdvice = appCon.getBean(TestDao.class);
        //执行方法
        testDaoAdvice.save();
        System.out.println("===============");
        testDaoAdvice.modify();
        System.out.println("===============");
        testDaoAdvice.delete();
        appCon.close();
    }
}
