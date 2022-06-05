package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller和Component注解一样，将下面的类交给spring管理，
// 只是Controller注解更直观知道下面的类的功能
//Component是表示一些中立的类
@Controller
public class GreetingController {
    //为该方法映射一个路径
    @GetMapping("/greeting.form")//只能以Get方式请求 对应POSTMapping
    public String greeting(String name,Model model){//接受用户请求的方法 name用户传来的名字，model对参数封装
        //方法体的逻辑，接受用户传来的一个参数name,将该请求转发到首页上
        model.addAttribute("userName",name);
        System.out.println("GreetingController调用greeting方法"+"name:"+name);
        return "greeting";
    }
}
