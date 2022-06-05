package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
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
	 * MultipartResolver配置 MultipartResolver解析文件上传请求 利用MultipartFile来进行接收文件
	 * MultipartResolver根据请求头部的的content-type判断是否含有”multipart/form-data”。如果有，则把请求封装成MultipartFile
	 */
	/*maxUploadSize 上传的最大字节数，-1代表没有任何限制
	maxInMemorySize 读取文件到内存中最大的字节数，默认是1024
	defaultEncoding 文件上传头部编码，默认是iso-8859-1，注意defaultEncoding必须和用户的jsp的pageEncoding属性一致，以便能正常读取文件
	uploadTempDir文件上传暂存目录，文件上传完成之后会清除该目录，模式是在servlet容器的临时目录，例如tomcat的话，就是在tomcat文件夹的temp目录
*/
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		//设置上传文件的最大值，单位为字节 -1代表没有任何限制
		multipartResolver.setMaxUploadSize(5400000);
		//设置请求的编码格式，默认为iso-8859-1
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}
}
