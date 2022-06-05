package controller;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.UserForm;
import service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	//得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(UserController.class);//来自apache的common-logging包
	//将服务层依赖注入到属性userService
	@Autowired
	 public UserService userService;
	/*首页跳转到登录页面*/

	@RequestMapping(value="/loginGo")
	public String loginGo(){
	return "login";
	}

	/*首页跳转到注册页面*/
	@RequestMapping(value="/registerGo")
	public String registerGo(){
		return "register";
	}

	/**
	 * 处理登录
	 */
	@RequestMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
		System.out.println("调用UserController的login方法");
		System.out.println("user:"+user);
		if(userService.login(user)){
			session.setAttribute("user", user);
			logger.info("成功");
//			System.out.println("登录成功");
			return "main";//登录成功，跳转到main.jsp 控制器类中处理方法的return语句默认就是转发实现，只不过实现的是转发到视图。
		}else{
			logger.info("失败");
//			System.out.println("登录失败");
			model.addAttribute("messageError", "用户名或密码错误");
			return "login";
		}	
	}
	/**
	 *处理注册
	 */
	@RequestMapping("/register")
	//使用@ModelAttribute("user")与model.addAttribute("user", user)功能相同
	//在register.jsp页面上可以使用EL表达式${user.uname}取出ModelAttribute的uname值
	public String register(@ModelAttribute("user") UserForm user,
						   Model model) {
		System.out.println("调用UserController的register方法");
		System.out.println("user:"+user);
		if(userService.register(user)){
			logger.info("成功");
//			System.out.println("注册成功，跳转登录页面");
			return "login";//注册成功，跳转到login.jsp
		}else{
			logger.info("失败");
			model.addAttribute("messageError","注册失败");
//			System.out.println("注册失败");
			return "register";//返回register.jsp
		}
	}
	@RequestMapping("/forwardGo")
	public String forwardGo(){
		return "forward:loginGo";
	}
	@RequestMapping("/redirectGo")
	public String redirectGo(){
		return "redirect:loginGo";
	}
	@RequestMapping("/redirectGoStatic")
	public String redirectGoStatic(){
		return "redirect:/html/NewFile.html";
	}
}
