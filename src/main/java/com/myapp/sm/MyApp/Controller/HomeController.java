package com.myapp.sm.MyApp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.sm.MyApp.Password;
import com.myapp.sm.MyApp.Model.Product;
import com.myapp.sm.MyApp.Model.User;
import com.myapp.sm.MyApp.Service.ProductService;
import com.myapp.sm.MyApp.Service.UserSrevice;

@RestController
public class HomeController {
	
	
	@Autowired 
	UserSrevice userservice;
	
	@Autowired 
	ProductService productService;
	
	
	



	public HomeController(UserSrevice userservice) {
		super();
		this.userservice = userservice;
	}



	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	
	
	@RequestMapping("/login")
	public String Login() {
		return "login.jsp";
	}
	
	
	@RequestMapping("/logout-success")
	public String Logout() {
		
		return "logout.jsp";
	}
	
	@RequestMapping("/reg")
	public String reg() {
		
		return "reg.jsp";
	}

	
	@GetMapping("/m")
		public void m() {
			System.out.println("hi........");
		}
	
	/*
	 * @RequestMapping("/registration") public String
	 * registration(@ModelAttribute("User") User user) { Password password=new
	 * Password() ;
	 * 
	 * 
	 * user.setPassword(password.hashPassword(user.getPassword()));
	 * userservice.save(user); return "login.jsp"; }
	 */
	
	@PostMapping("/registration")
	public void registration(@RequestBody User user) {
		
		System.out.println(user.getAdress());
		System.out.println(user.getFullname());
		
		//Password password=new Password() ;  
	  
	      
		//user.setPassword(password.hashPassword(user.getPassword()));
		//userservice.save(user);
		//return "login.jsp";
	}
	@RequestMapping("/addproduct")
	public String addproduct() {
		
		return "addproduct.jsp";
	}
	
	
	@RequestMapping("/saveproduct")
	public String saveproduct(@ModelAttribute("Product") Product product) {	  	
		
		product.setProductcode(product.getProductname().toUpperCase());
		productService.save(product);
		return "login.jsp";
	}
	

}
