package com.app.controller;

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

import com.app.pojos.Cart;
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
	public ModelAndView getCart(HttpSession session, Model map) {
		// session is the person who is currently logged in
		Customer customer = (Customer) session.getAttribute("customer_details");
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("customer:" + customer);
		System.out.println("cart:" + customer.getCart());
		System.out.println("cartItems:" + customer.getCart().getCartItems());

		mv.addObject("customer", customer);
		mv.addObject("showCart", true);

		return mv;
	}

	@PostMapping("/checkout")
	public String processCheckOut(@Valid Cart cart, BindingResult result, RedirectAttributes flashMap) {

		System.out.println("checkout method");
		System.out.println("Cart:" + cart);
		System.out.println("cartitems:" + cart.getCartItems());
		if (result.hasErrors()) {
			System.out.println("P.L errs " + result);
			// in case of P.L errors --forward clnt to reg form
			return "redirect:showcart";
		}

		// flashMap.addFlashAttribute("mesg", customerService.addCustomer(cart));
		return "redirect:/orders/payment";
	}

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam int productId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer_details");
		cartService.addCartItem(productId, customer.getCart());
		session.setAttribute("customer_details",customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";
	}

	@GetMapping("/increasequantity")
	public String increaceQuantity(@RequestParam int cartItemId, HttpSession session) {
		System.out.println("increase quantity method ");
		System.out.println("Cart item:" + cartItemId + "  " + 1);

		Customer customer = (Customer) session.getAttribute("customer_details");
		cartService.updateCartItem(cartItemId, 1, customer.getCart());

		session.setAttribute("customer_details",customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";

	}
	@GetMapping("/decreasequantity")
	public String decrementQuantity(@RequestParam int cartItemId, HttpSession session) {
		System.out.println("decrease quantity method ");
		System.out.println("Cart item:" + cartItemId + "  " + -1);
		
		Customer customer = (Customer) session.getAttribute("customer_details");
		
		cartService.updateCartItem(cartItemId, -1, customer.getCart());

		
		session.setAttribute("customer_details",customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";

	}

	@GetMapping("/removecartitem")
	public String deleteItem(@RequestParam int cartItemId, Model map, HttpSession session) {
		try {

			Customer customer = (Customer) session.getAttribute("customer_details");
			if (cartService.deleteCartItem(cartItemId , customer.getCart() )) {
				
				System.out.println("cart Item deleted");
				
				session.setAttribute("customer_details",customerService.getCustomerDetails(customer.getCustomerId()));
				map.addAttribute("mesg", "Item deleted successfully");
				
			}
		} catch (Exception e) {
			map.addAttribute("mesg", "Item not deleted");
		}
		return "redirect:/customer/cart/showcart";
	}

	@GetMapping("/checkout")
	public String checkoutCart() {
		return "redirect:/orders/payment";
	}
}
