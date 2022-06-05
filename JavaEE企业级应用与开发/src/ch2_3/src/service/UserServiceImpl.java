package service;
import org.springframework.stereotype.Service;
import entity.UserForm;
//注解为一个服务
@Service
public class UserServiceImpl implements UserService{
	@Override
	public boolean login(UserForm user) {
		System.out.println("UserServiceImpl的login业务");
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass()))
			return true;
		return false;
	}
	@Override
	public boolean register(UserForm user) {
		System.out.println("UserServiceImpl的register业务");
		if(user.getUname()!="" && user.getUpass()!=""&&user.getUpass().equals(user.getReupass()))
			return true;
		return false;
	}
}
