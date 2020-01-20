package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;
import com.app.service.CartService;
import com.app.service.CustomerService;
import com.app.service.ProductService;

@Controller
@RequestMapping("customer/cart")
public class CartController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	public CartController() {
		System.out.println("in cart controller ctor");
	}

	@GetMapping("/showcart")
	public ModelAndView getCart(HttpSession session,Model map)
	{	
		// session is the person who is currently logged in
		Customer customer = (Customer)session.getAttribute("customer_details");
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("customer:"+customer);
		System.out.println("cart:"+customer.getCart());
		System.out.println("cartItems:"+customer.getCart().getCartItems());
		//int cartId = customer.getCart().getCartId();
		mv.addObject("cartItems", customer.getCart().getCartItems());
		map.addAttribute("cart",customer.getCart());
		mv.addObject("showCart",true);
		//return "/customer/cartitems";
		return mv;
	}
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam int productId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer_details");
		cartService.addCartItem(productId, customer.getCart());
		return "redirect:/customer/cart/showcart";
	}
	 
	@GetMapping("/updatecartitem")
	public String showUpdateForm( @RequestParam int cartItemId, @RequestParam int quantity) {
		System.out.println("inside showUpdateForm method ");
		System.out.println("Cart item:" +cartItemId + "  "+quantity);
		cartService.updateCartItem(cartItemId, quantity);
		return "redirect:/customer/cart/showcart";
		
	}
	
	@GetMapping("/removecartitem")
	public String deleteItem(@RequestParam int cartItemId,Model map) {
		try {
			if(cartService.deleteCartItem(cartItemId)) {
				map.addAttribute("mesg", "Item deleted successfully");
			}
		}catch(Exception e) {
			map.addAttribute("mesg", "Item not deleted");
		}
		return "redirect:/customer/cart/showcart";
	}
	
}
