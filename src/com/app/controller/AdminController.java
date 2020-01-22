package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.Seller;
import com.app.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	ISellerService sellerService;

	public AdminController() {
		System.out.println("in Admin controller ctor");
	}

	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show login form");
		mv.addObject("adminLogin", true);
		return mv;
	}

	@PostMapping("/login") // @RequestMapping + method=post
	public ModelAndView processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes flashMap, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");

		System.out.println("in process login form");
		// invoke dao's method for authenticateAdmin.
		try {

			Admin admin = new Admin();
			admin = adminService.authenticateAdmin(email, password);

			// valid login
			session.setAttribute("admin_details", admin); // till logout
			System.out.println("admin info" + admin);
			flashMap.addFlashAttribute("mesg", "Login Successful");// till next request

			mv.addObject("adminTask", true);
			return mv;

		} catch (RuntimeException e) {

			System.out.println("err in admin controller " + e);
			map.addAttribute("mesg", "Invalid email or password");
			// invalid login
			mv.addObject("adminLogin", true);
			return mv;
		}

	}

	@GetMapping("/customerList")
	public ModelAndView getAllCustomer(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");

		System.out.println("inside getAllCustomer");
		try {
			List<Customer> list = customerService.getCustomerList();
			if (list.size() != 0) {
				map.addAttribute("customer_list", list);

				mv.addObject("customerList", true);
			}

		} catch (Exception e) {
			map.addAttribute("mesg", "List Not Found");
			mv.addObject("adminTask", true);
		}
		return mv;
	}

	@GetMapping("/sellerList")
	public ModelAndView getAllSeller(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");

		System.out.println("inside getAllSeller");
		try {

			List<Seller> list = sellerService.getSellerList();
			if (list.size() != 0) {
				map.addAttribute("seller_list", list);
				mv.addObject("sellerList", true);

			}
		} catch (Exception e) {
			map.addAttribute("mesg", "List Not Found");
			mv.addObject("adminTask", true);
		}
		return mv;
	}

	@GetMapping("/verifyseller")
	public String verifySeller(@RequestParam int sellerId, Model map) {

		System.out.println("inside verify Seller");
		try {

			Seller seller = sellerService.getSellerDetails(sellerId);
			System.out.println("seller:" + seller);
			if (seller != null) {
				seller.setStatus("verified");
				sellerService.updateSeller(sellerId, seller);
				return "redirect:/admin/sellerList";
			}
			return "redirect:/seller/error";
		} catch (Exception e) {
			map.addAttribute("mesg", "Seller Not Found");
			return "redirect:/seller/error";
		}
	}

	@GetMapping("/logout")
	public String showLogout(HttpSession session) {
		System.out.println("in logout page");
		session.invalidate();

		return "redirect:/login";
	}

}
