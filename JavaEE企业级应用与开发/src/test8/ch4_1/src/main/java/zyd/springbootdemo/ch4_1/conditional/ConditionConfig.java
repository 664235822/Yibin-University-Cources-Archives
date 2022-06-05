package zyd.springbootdemo.ch4_1.conditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConditionConfig {
	@Bean
	@Conditional(MyCondition.class)
	public MessagePrint myMessage() {
		return new MyMessagePrint();
	}
	@Bean
	@Conditional(YourCondition.class)
	public MessagePrint yourMessage() {
		return new YourMessagePrint();
	}
}
