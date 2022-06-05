package zyd.myBatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/toFindCustomerById")
	public String toFindCustomerById() {
		return "customerFind";
	}

	@RequestMapping("/toAddCustomer")
	public String toAddCustomer() {
		return "customerAdd";
	}

	@RequestMapping("/toUpdateCustomer")
	public String toUpdateCustomer() {
		return "customerUpdate";
	}

	@RequestMapping("/toDeleteCustomerById")
	public String toDeleteCustomerById() {
		return "customerDelete";
	}

	/**
	 * 根据id查询客户详情
	 */
	@RequestMapping("/findCustomerById")
	public String findCustomerById(String username, Model model) {
		Customer customer = customerService.findCustomerById(username);
		System.out.println("findCustomerById:" + username + "=" + customer);
		if (customer == null) {
			model.addAttribute("msg", "查询失败，该客户不存在");
			return "customerFind";
		}
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		model.addAttribute("customers", customers);
		//返回客户信息展示页面
		return "customerList";
	}

	@RequestMapping(value = "/listCustomers")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		System.out.println("customers:" + customers);
		model.addAttribute("customers", customers);
		return "customerList";
	}

	//
	@RequestMapping("/addCustomer")
	public String addCustomer(Customer customer, Model model) {
		if (customerService.addCustomer(customer)) {//添加成功后跳转客户列表页面
			return "redirect:listCustomers";

		}
		model.addAttribute("msg", "添加失败");
		//返回客户信息展示页面
		return "customerAdd";
	}

	@RequestMapping(value = "/updateCustomer")
	public String updateCustomer(Customer customer, Model model) {
		if (customerService.updateCustomer(customer)) {
			return "redirect:listCustomers";
		}
		model.addAttribute("msg", "更新失败");
		return "customerUpdate";
	}

	@RequestMapping(value = "/deleteCustomerById")
	public String deleteCustomerById(String username, Model model) {
		if (customerService.deleteCustomerById(username)) {
			return "redirect:listCustomers";
		}
		model.addAttribute("msg", "删除失败");
		return "customerDelete";
	}
}
