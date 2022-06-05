package service;
import java.util.ArrayList;
import entity.User;
public interface UserService {
	boolean addUser(User u);
	ArrayList<User> getUsers();
}
