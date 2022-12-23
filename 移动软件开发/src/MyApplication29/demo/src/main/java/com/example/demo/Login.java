package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
public class Login {
    @RequestMapping(value = "/loginget", method = RequestMethod.GET)
    public String loginget(HttpServletResponse response) {
        grant(response);
        System.out.println("get进来了");
        return "【get请求】登录成功";
    }

    @RequestMapping(value = "/loginpost", method = RequestMethod.POST)
    public String loginpost(@RequestParam String name, @RequestParam String pwd, HttpServletResponse response) {
        grant(response);
        if (name.equals(pwd)) {
            System.out.println("用户名和密码相等，均为"+name+"，登录成功");
            return "【Post请求】登录成功";
        }else {
            System.out.println("用户名和密码不相等，用户名："+name+"，密码："+pwd+"，登录成功");
            return "【Post请求】登录失败";
        }
    }
    private void grant(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache ");
    }

    @RequestMapping(value = "/testget", method = RequestMethod.GET)
    public String testget(@RequestParam String name, @RequestParam String pwd,HttpServletResponse response) {
        grant(response);
        String result = "";
        if(name.equals("a")&&pwd.equals("123")){
            System.out.println("【testget】get进来了");
            result =  "【get请求】登录成功，您有权限";
        }else if(name.equals("a")&&pwd.equals("1234")){
            System.out.println("【testget】get进来了");
            result = "【get请求】登录失败，您没有权限";
        }
        return result;
    }
    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public String testpost(@RequestParam String name, @RequestParam String pwd, HttpServletResponse response) {
        grant(response);
        String result = "";
        if (name.equals(pwd)) {
            System.out.println("【testpost】用户名和密码相等，均为"+name+"，登录成功");
            result =  "【testpost，Post请求】登录成功";
        }else {
            System.out.println("【testpost】用户名和密码不相等，用户名："+name+"，密码："+pwd+"，登录失败");
            result= "【testpost，Post请求】登录失败";
        }
        return result;
    }
}
