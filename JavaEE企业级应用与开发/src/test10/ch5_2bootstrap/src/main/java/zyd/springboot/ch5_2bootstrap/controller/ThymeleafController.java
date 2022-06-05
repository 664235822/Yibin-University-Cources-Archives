package zyd.springboot.ch5_2bootstrap.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zyd.springboot.ch5_2bootstrap.model.Book;

@Controller
public class ThymeleafController {
	@RequestMapping("/")
	public String index(Model model) {
		Book teacherGeng = new Book(
				"9787302464259", 
				59.5, 
				"Java 2实用教程（第5版）",
				"清华大学出版社",
				"耿祥义",
				"073423-02.jpg"
				);
		List<Book> chenHeng = new ArrayList<Book>();
		Book b1 = new Book(
				"9787302529118", 
				69.8, 
				"Java Web开发从入门到实战（微课版）", 
				"清华大学出版社", 
				"陈恒",
				"082526-01.jpg"
				);
		chenHeng.add(b1);
		Book b2 = new Book(
				"9787302502968", 
				69.8, 
				"Java EE框架整合开发入门到实战——Spring+Spring MVC+MyBatis（微课版）",
				"清华大学出版社", 
				"陈恒",
				"079720-01.jpg");
		chenHeng.add(b2);
		model.addAttribute("aBook", teacherGeng);
		model.addAttribute("books", chenHeng);
		return "index";
	}
}
