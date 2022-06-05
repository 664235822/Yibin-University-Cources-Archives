package zyd.myBatis.service;
import zyd.myBatis.po.User;

public interface UserService {
    public boolean register(User userForm);
    public User login(User userForm);
}
