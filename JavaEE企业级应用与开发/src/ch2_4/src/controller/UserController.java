package controller;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.User;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	// 得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/input")
	public String inputUser(Model model) {
		System.out.println("UserController执行inputUser方法");
		HashMap<String, String> hobbys = new HashMap<String, String>();
		hobbys.put("篮球", "篮球");
		hobbys.put("乒乓球", "乒乓球");
		hobbys.put("电玩", "电玩");
		hobbys.put("游泳", "游泳");
	     // 如果model中没有user属性，userAdd.jsp会抛出异常，因为表单标签无法找到
	 // modelAttribute属性指定的form backing object
		model.addAttribute("user", new User());
		model.addAttribute("hobbys", hobbys);
	    model.addAttribute("carrers", new String[] { "教师", "学生", "coding搬运工", "IT民工", "其它" });
		model.addAttribute("houseRegisters", new String[] { "北京", "上海", "广州", "深圳", "其它" });
		return "userAdd";//跳转到userAdd.jsp
	}
	@RequestMapping(value = "/save")
	public String addUser(@ModelAttribute User user, Model model) {
		System.out.println("UserController执行addUser方法");
		if (userService.addUser(user)) {
			logger.info("成功");
			System.out.println("addUser添加用户成功");
			System.out.println("user:"+user);
			return "redirect:/user/list";//重定向到list方法
		} else {
			logger.info("失败");
			System.out.println("addUser添加用户失败");
			HashMap<String, String> hobbys = new HashMap<String, String>();
			hobbys.put("篮球", "篮球");
			hobbys.put("乒乓球", "乒乓球");
			hobbys.put("电玩", "电玩");
			hobbys.put("游泳", "游泳");
			// 这里不需要model.addAttribute("user", new
			// User())，因为@ModelAttribute指定form backing object
			model.addAttribute("hobbys", hobbys);
			model.addAttribute("carrers", new String[] { "教师", "学生", "coding搬运工", "IT民工", "其它" });
			model.addAttribute("houseRegisters", new String[] { "北京", "上海", "广州", "深圳", "其它" });
			model.addAttribute("errorMsg","添加失败！，职业不能选择IT民工");
			return "userAdd"; // 控制器类中处理方法的return语句默认就是转发实现，只不过实现的是转发到视图。
		}
	}

	@RequestMapping(value = "/list")
	public String listUsers(Model model) {
		System.out.println("UserController执行listUsers方法");
		List<User> users = userService.getUsers();
		System.out.println("users:"+users);
		model.addAttribute("users", users);
		return "userList";
	}
	@RequestMapping(value = "/listMV")
	/*若返回类型为ModelAndView类型，需要方法结束时，定义ModelAndView,将model和view分别进行设置，*/
	public ModelAndView listUsersMV() {
		System.out.println("UserController执行listUsers2方法");
		List<User> users = userService.getUsers();
		System.out.println("users:"+users);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("users",users);
		modelAndView.setViewName("userList");
		return modelAndView;
	}
}
