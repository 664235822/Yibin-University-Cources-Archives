package zyd.springbootdemo.ch4_1.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@PropertySource({"test.properties","ok.properties"})
public class PropertySourceValueReaderOhterController {
	@Value("${my.msg}")
    private String mymsg;
	@Value("${your.msg}")
    private String yourmsg;
	@RequestMapping("/testProperty")
	public String testProperty() {
		return "其他配置文件test.properties：" + mymsg + "<br>" + "其他配置文件ok.properties：" + yourmsg;
	}
}
