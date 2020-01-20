package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/index")
	public ModelAndView showHomePage() {
		ModelAndView mv=new ModelAndView("/home/index");
		mv.addObject("clickLogin", true);
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mv=new ModelAndView("/home/index");
		mv.addObject("clickLogin", true);
		return mv;
	}
	
	@GetMapping("/about")
	public ModelAndView showAboutPage() {
		ModelAndView mv=new ModelAndView("/home/index");
		mv.addObject("clickAbout", true);
		return mv;
	}
	
	
	
	
}
