package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;
import com.app.pojos.Payment;
import com.app.service.ICustomerService;
import com.app.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	IOrdersService ordersService;
	
	@Autowired
	ICustomerService customerService;

	public OrdersController() {
		System.out.println("orders controller");
	}
	
	@GetMapping("/payment")
	public ModelAndView showPaymentPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			Customer customer = (Customer) session.getAttribute("customer_details");
			System.out.println("Cart in payment:" + customer.getCart());
			mv.addObject("showPaymentPage", true);
		} catch (Exception e) {
			mv.addObject("error", true);
		}
		return mv;
	}

	@GetMapping("/makepayment")
	public String makePayment(HttpSession session) {

		try {
			Customer customer = (Customer) session.getAttribute("customer_details");
			Payment payment = ordersService.makePayment(customer);
			System.out.println("payment:"+payment);
			session.setAttribute("payment_details", payment);
			return "redirect:/orders/placeorder";
		}
		catch(Exception ex) {
			System.out.println("exception:"+ex);
			return "redirect:/orders/placeorder";
		}

	}

	@PostMapping("/placeorder")
	public ModelAndView placeOrders(HttpSession session) {
		
		ModelAndView mv = new ModelAndView("/home/index");

		try {
			Customer customer = (Customer) session.getAttribute("customer_details");
			System.out.println("Customer:" + customer);
			Payment payment = (Payment) session.getAttribute("payment_details");
			session.setAttribute("payment_details", null);
			System.out.println("Payment:" + payment);
			ordersService.addOrders(customer, payment);
			System.out.println("Order placed controller...");
			session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
			mv.addObject("placedOrder", true);
		} catch (Exception e) {
			mv.addObject("error", true);
		}
		return mv;
	}

}
