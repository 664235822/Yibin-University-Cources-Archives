package zyd.springboot.ch5_1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import zyd.springboot.ch5_1.model.LoginBean;

@Controller
public class LoginController {
	@RequestMapping("/toLogin")
	public String toLogin(Model model) {
		/*
		* loginBean与login.html中的th:object="${loginBean}"相同，
		* 类似于SpringMVC的表单绑定
		* */
		System.out.println("跳转到登录页面");
		LoginBean loginBean=new LoginBean();
		loginBean.setUname("1");
		model.addAttribute("loginBean",loginBean );
		return "login";
	}
	@RequestMapping("/login")
	/*
	* @ModelAttribute LoginBean loginBean接收login.html页面中的表单数据
	* 并将loginBean对象保存到model返回给result.html页面显示
	* */
	 public String greetingSubmit(@ModelAttribute LoginBean loginBean) {
		System.out.println("测试提交的数据：" + loginBean.getUname());
	    return "result";
	 }
}
