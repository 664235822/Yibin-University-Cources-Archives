package zyd.springboot.ch5_1;
import java.util.Locale;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
@EnableAutoConfiguration
/*
//如果想定义一些定制化的功能，只要写这个配置类，然后将它交给springboot，springboot就会帮我们自动装配
该配置类实现WebMvcConfigurer接口，并配置语言区域选择。

* */
public class LocaleConfig implements WebMvcConfigurer {
	/**
	 *根据用户本次会话过程中的语义设定语言区域
	 *（如用户进入首页时选择的语言种类）
     * 使用自己创建的 LocaleResolver来创建自己的逻辑，去实现国际化
	 * @return
	 */
	@Bean  //使用该注解该类必须是配置类，否则不生效
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //默认语言
        slr.setDefaultLocale(Locale.CHINA);
        System.out.println("设置中国为默认语言环境");
        return slr;
    }
	/**
	 * 使用SessionLocaleResolver存储语言区域时，
	 * 必须配置localeChangeInterceptor拦截器
	 * @return
	 */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        //选择语言的参数名
        lci.setParamName("locale");
        System.out.println("配置localeChangeInterceptor拦截器 设置语言的参数名为locale");
        return lci;
    }
    /**
         * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("注册拦截器LocaleChangeInterceptor");
        registry.addInterceptor(localeChangeInterceptor());
    }
}
