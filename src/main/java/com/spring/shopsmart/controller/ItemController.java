package com.spring.shopsmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.shopsmart.exception.InvalidCredentialsException;
import com.spring.shopsmart.model.Items;
import com.spring.shopsmart.model.User;
import com.spring.shopsmart.service.ItemService;
import com.spring.shopsmart.service.UserService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService; //DI
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/login-form")
	public String handleLogin(HttpServletRequest req, HttpSession session) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user =  userService.verifyLogin(username,password);
			
				session.setAttribute("username", username);
				//fetch all courses
				List<Items> items =  itemService.fetchAllItems();
				//List listCourses courseService.fetchAllCourses();
				req.setAttribute("listItems", items);
				
//				//fetch all enrolled course 
//				List<Course> enrolledCourses =  courseService.getEnrolledCourses(session.getAttribute("username"));
//				req.setAttribute("enrolledCourses", enrolledCourses);
				
				return "dashboard"; 
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg",e.getMessage());
			return "login";
		} 
	}
	
	@GetMapping("/dashboard")
	public String goToDashboard(HttpServletRequest req,HttpSession session) {
		//fetch all courses
		List<Items> items =  itemService.fetchAllItems();
		//List listCourses courseService.fetchAllCourses();
		req.setAttribute("listItems", items);
		
		//fetch all enrolled course 
//		List<Course> enrolledCourses =  courseService.getEnrolledCourses(session.getAttribute("username"));
//		req.setAttribute("enrolledCourses", enrolledCourses);
		return "dashboard";
	}
	
	@GetMapping("/delete-item")
	public String deleteItem(HttpServletRequest req) {
		String iid = req.getParameter("iid");
		itemService.softDelete(iid);
		return "redirect:/dashboard";
	}
	
}
