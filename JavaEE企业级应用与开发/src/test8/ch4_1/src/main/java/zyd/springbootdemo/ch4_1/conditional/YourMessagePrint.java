package zyd.springbootdemo.ch4_1.conditional;
public class YourMessagePrint implements MessagePrint{
	@Override
	public String showMessage() {
		return "test.properties文件不存在！";
	}

}
