package zyd.springboot.ch5_1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/i18n")
public class I18nTestController {
	@RequestMapping("/first")
	public String testI18n(String locale){
		System.out.println("locale："+locale);
		return "/i18n/first";
	}
	@RequestMapping("/admin")
	public String admin(){
		return "/i18n/admin";
	}
	@RequestMapping("/before")
	public String before(){
		return "/i18n/before";
	}
}
