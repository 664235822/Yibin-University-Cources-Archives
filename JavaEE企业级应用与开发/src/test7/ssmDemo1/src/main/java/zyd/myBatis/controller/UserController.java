package zyd.myBatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zyd.myBatis.po.User;
import zyd.myBatis.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model, HttpSession session) {
		User userDB = userService.login(user);
		if (userDB != null) {
			// 将用户对象添加到Session
			session.setAttribute("USER_SESSION", user);
			// 重定向到主页面的跳转方法
			return "redirect:main";
		}
		model.addAttribute("msg", "用户名或密码错误，请重新登录！");
		return "login";
	}

	/**
	 * 向用户主页面跳转
	 */
	@RequestMapping(value = "/main")
	public String toMain() {
		return "main";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:toLogin";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, Model model, HttpSession session) {
		boolean isok = userService.register(user);
		if (isok) {
			model.addAttribute("msg", "注册成功，请登录！");
			return "login";
		}
		model.addAttribute("msg", "注册失败！");
		return "register";
	}
}
