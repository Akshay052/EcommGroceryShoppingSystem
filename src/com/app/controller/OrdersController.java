package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Cart;
import com.app.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	IOrdersService ordersService;
	
	@GetMapping("/payment")
	public ModelAndView showPaymentPage(RedirectAttributes flashmap) {
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			Cart cart = (Cart) flashmap.getAttribute("cart");
			System.out.println("Cart in payment:" + cart);
			mv.addObject("showPaymentPage", true);
		} catch (Exception e) {
			mv.addObject("error", true);
		}
		return mv;
	}
	
	
}
