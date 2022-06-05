package config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
public class WebConfig implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ctx 
		= new AnnotationConfigWebApplicationContext();
		ctx.register(SpringMVCConfig.class);//注册Spring MVC的Java配置类SpringMVCConfig
		ctx.setServletContext(arg0);//和当前ServletContext关联
		/**
		 * 注册Spring MVC的DispatcherServlet
		 */
		Dynamic servlet = arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
