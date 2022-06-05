package aspectj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration              //声明一个配置类
@ComponentScan("aspectj")   //自动扫描aspectj包下使用的注解
@EnableAspectJAutoProxy     //开启Spring对Aspectj的支持
public class AspectjAOPConfig {
}
