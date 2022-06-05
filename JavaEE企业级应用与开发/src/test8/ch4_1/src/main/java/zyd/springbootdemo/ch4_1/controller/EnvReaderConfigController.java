package zyd.springbootdemo.ch4_1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EnvReaderConfigController {
	@Autowired
	private Environment env;//方法一：使用Environment读取配置文件
	@RequestMapping("/testEnv")
	public String testEnv() {
		/*读取application.properties文件中的test.msg
		* 也可以读取其他的配置文件*/
		return "方法一：" + env.getProperty("test.msg") ;
	}
}
