package zyd.springbootdemo.ch4_1.model;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component//使用Component注解，声明一个组件，被控制器依赖注入
@ConfigurationProperties(prefix = "obj")//obj为配置文件中key的前缀
public class StudentProperties {
	private String sname;
	private int sage;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
    public String toString() {
        return "StudentProperties [sname=" + sname + ", sage=" + sage + "]";
    }
}
