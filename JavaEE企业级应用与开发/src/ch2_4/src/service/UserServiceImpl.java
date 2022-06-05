package service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import entity.User;
@Service
public class UserServiceImpl implements UserService{
	//使用静态集合变量users模拟数据库
	private static ArrayList<User> users = new ArrayList<User>();
	@Override
	public boolean addUser(User u) {
		System.out.println("Service层调用addUser");
		if(!"IT民工".equals(u.getCarrer())){//不允许添加IT民工
			users.add(u);
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<User> getUsers() {
		System.out.println("Service层调用getUsers");
		return users;
	}

}
