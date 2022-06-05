package com.example.demo;

import com.dao.UserDaoImpl;

public class DaoTestMain {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setId(1);
        userDao.setName("张三");
        userDao.say();
    }
}
