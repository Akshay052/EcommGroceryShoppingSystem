package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Category;
import com.app.pojos.Customer;
import com.app.service.ICategoryService;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ICategoryService categoryService;

	public CustomersController() {
		System.out.println("in Customer controller ctor");
	}

	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("in show login form");
		mv.addObject("customerLogin",true);
		return mv;
	}

	// request handling method to process login form
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes flashMap, HttpSession session) {
		
		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {

			Customer customer = new Customer();
			customer = customerService.authenticateCustomer(email, password);

			// valid login
			session.setAttribute("customer_details", customer);	// till logout
			System.out.println("Customer info" + customer);
			flashMap.addFlashAttribute("mesg", "Login Successful");// till next request

			return "redirect:/customer/categories";
			

		} catch (RuntimeException e) {

			System.out.println("err in Customer controller " + e);
			map.addAttribute("mesg", "Invalid email or password");
			// invalid login
			return "redirect:/customer/login";
		
		}

	}

	@GetMapping("/categories")
	public ModelAndView showCategories(Model map, HttpSession session) {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("in show categories form");
		List<Category> list = categoryService.getCategoryList();
		mv.addObject("showCategories",true);
        session.setAttribute("category_list", list);
		//return "/customer/login";
		return mv;
	}
	
	@GetMapping("/account")
	public ModelAndView showAccount() {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("in show account");

		//return "/customer/login";
		mv.addObject("customerAccount",true);
		return mv;
	}
	
	@GetMapping("/list")
	public String getAllCustomer(Model map) {
		System.out.println("inside getAllCustomer");
		List<Customer> list = customerService.getCustomerList();
		if (list.size() != 0) {
			map.addAttribute("customer_list", list);

			return "/customer/list";
		} else {
			map.addAttribute("mesg", "List Not Found");
			return "/customer/task";
		}
	}

	@GetMapping("/register")
	public ModelAndView showRegForm(Model map) {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("inside showRegForm method ");
		map.addAttribute("Customer", new Customer());
		mv.addObject("customerRegister",true);
		return mv;
	}

	@PostMapping("/register")
	public ModelAndView processRegForm(@Valid Customer c, BindingResult result, RedirectAttributes flashMap) {
		ModelAndView mv=new ModelAndView("/home/index");

		System.out.println("inside processRegForm method");

		if (result.hasErrors()) {
			System.out.println("P.L errs " + result);
			// in case of P.L errors --forward clnt to reg form
			mv.addObject("customerRegister",true);
			return mv;
		}

		flashMap.addFlashAttribute("mesg", customerService.addCustomer(c));
		mv.addObject("customerLogin",true);
		return mv;
	}

	@GetMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam int customerId, Model map) {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("inside showUpdateForm method ");
		map.addAttribute("c", customerService.getCustomerDetails(customerId));
		mv.addObject("customerUpdate",true);
		return mv;
	}
	
	@PostMapping("/update")
	public String updateCustomer(@RequestParam int customerId, @Valid Customer customer, BindingResult result,
			Model map) {
		System.out.println("in update Customer" + customerId + " " + customer);
		try {
			if (customerService.updateCustomer(customerId, customer)) {
				map.addAttribute("mesg", "Customer updated successfully");
				return "/customer/list";
			}

		} catch (Exception e) {
			map.addAttribute("mesg", "Customer NOT Updated ");
			return "/customer/list";
		}
		return "/customer/list";

	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam int customerId,Model map) {
		try {
			if(customerService.deleteCustomer(customerId)) {
				map.addAttribute("mesg", "Customer deleted successfully");
				return "redirect:/customer/list";

			}
		}catch(Exception e) {
			map.addAttribute("mesg", "Customer not deleted");
		}
		return "redirect:/customer/list";
	}

	@GetMapping("/logout")
	public String showLogout(HttpSession session) {
		System.out.println("in logout page");
		session.invalidate();
		
		return "redirect:/customer/login";
	}

	@GetMapping("/task")
	public ModelAndView showtask() {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("in show task");
		mv.addObject("customerTask",true);
		return mv;
	}

}