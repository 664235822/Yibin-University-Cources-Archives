package zyd.myBatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zyd.myBatis.mapper.UserMapper;
import zyd.myBatis.po.User;
import zyd.myBatis.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	//注解注入UserMapper
	@Autowired
	private UserMapper userMapper;

	//添加用户
	@Override
	public boolean register(User userForm) {
		this.userMapper.addUser(userForm);
		return true;
	}

	@Override
	public User login(User userForm) {
		User userDB = this.userMapper.findUserByUsername(userForm.getUsername());
		if (userDB != null) {
			if (userDB.getPassword().equals(userForm.getPassword())) {
				return userDB;
			}
		}
		return null;

	}
}
