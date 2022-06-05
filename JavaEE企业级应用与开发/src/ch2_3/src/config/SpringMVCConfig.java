package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import interceptor.MyInteceptor;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller","service"})
public class SpringMVCConfig implements WebMvcConfigurer {
	/**
	 * 配置视图解析器
	 */
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	/**
	 * 配置静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/html/**").addResourceLocations("/html/");
		//addResourceHandler指的是对外暴露的访问路径
		//addResourceLocations指的是静态资源存放的位置
	}
	/**
	 * 配置拦截器Bean
	 */
	@Bean
	public MyInteceptor myInteceptor() {
		return new MyInteceptor();
	}
	/**
	 * 重写addInterceptors方法注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInteceptor());
	}
	/**
	 * MultipartResolver配置
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		//设置上传文件的最大值，单位为字节
		multipartResolver.setMaxUploadSize(5400000);
		//设置请求的编码格式，默认为iso-8859-1
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}
}
