package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(User user) {
        User obj = userMapper.login(user);
        if (obj == null) {
            return "没有账号";
        }
        return "登录成功";
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(User user) {
        try {
            userMapper.register(user);
            return "注册成功";
        } catch (Exception e) {
            return "注册失败";
        }
    }
}
