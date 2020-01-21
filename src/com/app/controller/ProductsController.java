package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.service.ICategoryService;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductsController {

	@Value("${upload_image_path}")
	private String imagePath;

	@Autowired
	IProductService productService;

	@Autowired
	ICategoryService categoryService;

	public ProductsController() {
		System.out.println("in products controller ctor");
	}

	@GetMapping("/listbyseller")
	public ModelAndView retrieveProductsBySeller(@RequestParam int sellerId, Model map) {
		System.out.println("inside getAllProductsby seller");
		ModelAndView mv = new ModelAndView("/home/index");

		List<Product> list = productService.retrieveProductsBySeller(sellerId);
		if (list.size() != 0) {
			map.addAttribute("product_list", list);
			mv.addObject("productsBySeller", true);
			return mv;
		} else {
			map.addAttribute("mesg", "List Not Found");
			mv.addObject("errorinseller", true);
			return mv;
		}
	}

	@GetMapping("/listbycategory")
	public ModelAndView retrieveProductsByCatagory(@RequestParam String categoryName, Model map) {
		System.out.println("inside getAllProductsby Catagory");
		ModelAndView mv = new ModelAndView("/home/index");

		Category category = categoryService.getCategoryDetails(categoryName);
		System.out.println(category);

		if (category.getProducts().size() != 0) {
			System.out.println("list added");
			map.addAttribute("product_list", category.getProducts());
			mv.addObject("productList", true);
			return mv;
		} else {
			System.out.println("list not found");
			map.addAttribute("mesg", "List Not Found");
			return mv;
		}
	}

	@GetMapping("/addproduct")
	public ModelAndView addProduct(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showRegForm method ");
		map.addAttribute("product", new Product());
		mv.addObject("categoryList", categoryService.getCategoryList());
		mv.addObject("addProduct", true);
		return mv;
	}

	@PostMapping("/addproduct")
	public String addProduct(@Valid Product product, BindingResult result, @RequestParam String category,
			HttpSession session) {

		System.out.println("inside addProduct post method");
		try {
			System.out.println("Product:" + product);
			session.setAttribute("product", product);
			session.setAttribute("categoryName", category);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:selectimage";
	}

	@GetMapping("/selectimage")
	public ModelAndView uploadImage(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside show image upload ");
		mv.addObject("uploadImage", true);
		return mv;
	}

	@PostMapping("/uploadimage")
	public String addImage(@RequestParam MultipartFile file, HttpSession session) {

		String uploadLocation = imagePath;
		//C:\Users\tnpat\Documents\ProRev\EcommerceMVC\WebContent\resources\images\products
		System.out.println("uploadLocation:" + uploadLocation);
		if (file.isEmpty()) {
			System.out.println("file is empty");
		}

		try {
			
			Product product = (Product) session.getAttribute("product");
			// Get the file and save it somewhere

			File dest = new File(uploadLocation, file.getOriginalFilename());
			// file transferred to server side folder
			file.transferTo(dest);

			System.out.println("upload location :" + uploadLocation + "//" + file.getOriginalFilename());

			System.out.println("You successfully uploaded " + file.getOriginalFilename());
			// set product url
			product.setImageUrl(file.getOriginalFilename());
			// persist product to db
			String categoryName = (String) session.getAttribute("categoryName");
			Seller seller = (Seller) session.getAttribute("seller_details");
			System.out.println("Product adding status:" + productService.addProduct(product, categoryName, seller));

		} catch (IOException e) {
			e.printStackTrace();

		}
		return "redirect:/seller/task";

	}

	@GetMapping("/delete")
	public ModelAndView deleteSeller(@RequestParam int id, Model map) {
		ModelAndView mv = new ModelAndView("/home/index");

		try {
			if (productService.deleteProduct(id)) {
				map.addAttribute("mesg", "product deleted successfully");
			}
		} catch (Exception e) {
			map.addAttribute("mesg", "product not deleted");
		}
		mv.addObject("sellertask", true);
		return mv;
	}

	@GetMapping("/details")
	public ModelAndView getProductDetails(@RequestParam int productId, Model map) {

		ModelAndView mv = new ModelAndView("/home/index");
		try {
			map.addAttribute("product", productService.getProductDetails(productId));
		} catch (Exception e) {
			map.addAttribute("mesg", "product not available");
		}
		mv.addObject("productDetails", true);

		return mv;
	}
}
