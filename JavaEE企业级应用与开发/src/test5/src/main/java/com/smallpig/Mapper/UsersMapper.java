package com.smallpig.Mapper;

import com.smallpig.User.User;

import java.util.List;

public interface UsersMapper {

    List<User> listUsers();

    User selectUserOne(int id);

    void deleteById(int id);

    void insertUser(User user);
}
