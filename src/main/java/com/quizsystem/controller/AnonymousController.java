package com.quizsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quizsystem.model.Course;
import com.quizsystem.model.Role;
import com.quizsystem.model.User;
import com.quizsystem.service.CourseService;
import com.quizsystem.service.RoleService;
import com.quizsystem.service.UserService;

@Controller
public class AnonymousController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public String quizPage(Model model){
		List<Course> courses = new ArrayList<>();
		courses = courseService.getAllCourse();
		model.addAttribute("courses",courses);
		return "quiz";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String saveUser(@ModelAttribute(name = "user") User user) {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.findRoleById(2));
		user.setRoles(roles);
		
		user.setActive(1);
		
		userService.save(user);
		return "redirect:/register?success";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/access-denied")
	public String accessDenied() {
		return "accessDenied";
	}
	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
}
