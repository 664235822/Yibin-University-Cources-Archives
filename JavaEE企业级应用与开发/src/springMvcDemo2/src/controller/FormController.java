package controller;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @RequestMapping("/form1.action")//post Get方式请求都可以请求
    public  String form1(){
        System.out.println("FormController调用form1方法");
        return "form1";
    }
    @RequestMapping("/form11.action")//post Get方式请求都可以请求
    public  String form11(){
        System.out.println("FormController调用form11方法");
        return "form11";
    }
    @RequestMapping("/form2.action")//post Get方式请求都可以请求
    public  String form2(){
        System.out.println("FormController调用form2方法");
        return "form2";
    }

    @RequestMapping("/hello1.action")//post Get方式请求都可以请求
    public  String hello1(String username, String password, int age, Model model){//参数处理有
        System.out.println("FormController调用hello1方法"+username+","+age+","+password);
        model.addAttribute("name",username);
        model.addAttribute("pw",password);
        model.addAttribute("age",age);
        return "welcome1";
    }
    @RequestMapping("/hello11.action")//post Get方式请求都可以请求
    public  String hello11(@RequestParam String username, @RequestParam String password,
                           @RequestParam int age, Model model){//参数处理有
        System.out.println("FormController调用hello11方法"+username+","+age+","+password);
        model.addAttribute("name",username);
        model.addAttribute("pw",password);
        model.addAttribute("age",age);
        return "welcome1";
    }
    @RequestMapping("/hello2.action")//post Get方式请求都可以请求
    public  String hello2(User user,Model model){
        //传入的参数是自定义类对象，spring根据jsp中用输入的数据，根据字段名相同自动封装对象
        System.out.println("FormController调用hello2方法"+"user对象:"+user);
        model.addAttribute("user",user);
        return "welcome2";
    }



}
