package zyd.springboot.ch5_1.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestThymeleafController {
	//若将首页放在templates文件夹下，则使用该请求路径的映射 动态跳转（通过控制器）
	//若未用该请求路径，表示，默认跳转到static/index.html
	@RequestMapping("/")
	public String test(){
		//根据Tymeleaf模板，默认将返回src/main/resources/templates/index.html
		System.out.println("跳转主页面");
		return "index";
	}
	@RequestMapping("/testObject")
	public String testObject(Model model) {
		//系统时间new Date()
		model.addAttribute("nowTime", new Date());
		//系统日历对象
		model.addAttribute("nowCalendar", Calendar.getInstance());
		//创建BigDecimal对象
		BigDecimal money = new BigDecimal(2019.613);
		model.addAttribute("myMoney", money);
		//字符串
		String tsts = "Test strings";
		model.addAttribute("str", tsts);
		//boolean类型
		boolean b = false;
		model.addAttribute("bool", b);
		//数组（这里不能使用int定义数组）
		Integer aint[] = {1,2,3,4,5};
		model.addAttribute("mya", aint);
		//List列表1
		List<String> nameList1 = new ArrayList<String>();
		nameList1.add("陈恒1");
		nameList1.add("陈恒3");
		nameList1.add("陈恒2");
		model.addAttribute("myList1", nameList1);
		//Set集合
		Set<String> st = new HashSet<String>();
		st.add("set1");
		st.add("set2");
		model.addAttribute("mySet", st);
		//Map集合
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		model.addAttribute("myMap", map);
		//List列表2
		List<String> nameList2 = new ArrayList<String>();
		nameList2.add("张三");
		nameList2.add("李四");
		nameList2.add("王二");
		model.addAttribute("myList2", nameList2);
		//根据Tymeleaf模板，默认将返回src/main/resources/templates/showObject.html
		return "showObject";
	}
}
