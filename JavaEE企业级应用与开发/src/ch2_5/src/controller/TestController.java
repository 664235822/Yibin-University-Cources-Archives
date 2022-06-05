package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import entity.Person;
@Controller
public class TestController {
	/**
	 * 接收页面请求的JSON数据，并返回JSON格式结果
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public List<Map<String, Object>> testJson(@RequestBody Person user) {// 将ajax（datas）发出的请求写入 user 对象中
		//打印接收的JSON格式数据
		System.out.println("pname=" + user.getPname() +
				", password=" + user.getPassword() + ",page=" + user.getPage());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pname", "张三");
		map.put("password", "123456");
		map.put("page", 25);
		//返回一个Map<String, Object>对象
		//return map;
		//返回一个List<Map<String, Object>>对象
		List<Map<String, Object>> allp = new ArrayList<Map<String, Object>>();
		allp.add(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("pname", "李四");
		map1.put("password", "54321");
		map1.put("page", 55);
		allp.add(map1);
		System.out.println("返回前端的数据，以json格式返回"+allp);
		return allp;
	}

}
