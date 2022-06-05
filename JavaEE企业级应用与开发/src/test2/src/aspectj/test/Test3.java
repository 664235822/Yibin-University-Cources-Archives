package aspectj.test;

import aspectj.config.AspectjAOPConfig;
import aspectj.dao.AspectjDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectjAOPConfig.class);
        AspectjDao aspectjDao = applicationContext.getBean(AspectjDao.class);
        aspectjDao.save();
        aspectjDao.modify();
        aspectjDao.delete();
    }

}
