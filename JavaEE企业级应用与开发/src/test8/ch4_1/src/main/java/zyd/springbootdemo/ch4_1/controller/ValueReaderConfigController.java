package zyd.springbootdemo.ch4_1.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ValueReaderConfigController {
	//方法二：使用@Value注解读取配置文件的内容
	@Value("${test.msg}")/*读取application.properties文件中的test.msg也可以读取其他的配置文件*/
    private String msg;
	@RequestMapping("/testValue")
	public String testValue() {
		return "方法二：" + msg;
	}
}
