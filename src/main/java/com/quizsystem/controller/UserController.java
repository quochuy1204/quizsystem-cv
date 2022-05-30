package com.quizsystem.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizsystem.dto.QuestionList;
import com.quizsystem.model.Course;
import com.quizsystem.model.Question;
import com.quizsystem.model.Result;
import com.quizsystem.model.Role;
import com.quizsystem.model.User;
import com.quizsystem.service.CourseService;
import com.quizsystem.service.QuestionService;
import com.quizsystem.service.ResultService;
import com.quizsystem.service.RoleService;
import com.quizsystem.service.UserService;
import com.sun.istack.Nullable;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	Boolean submitted = false;

	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ResultService resultService;

	// This method will return list question belong to the course that user chose
	@RequestMapping(value = "/course/listquestion", method = RequestMethod.GET)
	public String getAllQuestionByCourseId(@RequestParam(name = "course_id") int course_id, Model model) {
		QuestionList questionList = new QuestionList();
		questionList = questionService.getQuestionAllByCourseId(course_id);

		Course course = new Course();
		course = courseService.getCourseById(course_id);
		submitted = false;
		model.addAttribute("questionList", questionList);
		model.addAttribute("course", course);
		return "listQuestionByCourseforUser";
	}

	// This method will execute when user submit their answer
	@RequestMapping(value = "/question/submit", method = RequestMethod.POST)
	public String submitQuestion(@ModelAttribute(name = "questionList") QuestionList questionList, Model model,
			HttpServletRequest request) {

		if (!submitted) {
			// create new Result Object
			Result result = new Result();

			// get the course_id
			int course_id = Integer.parseInt(request.getParameter("course_id"));

			// get the course_name
			Course course = courseService.getCourseById(course_id);
			String course_name = course.getCourseName();

			// get the user information
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();
			User user = new User();
			user = userService.getUserByEmail(email);

			int user_id = user.getId();
			String user_name = user.getEmail();

			// get the correct score
			int score = resultService.getCorrectScore(questionList);

			// set the score for the new result
			result.setScore(score);
			result.setCourseId(course_id);
			result.setCourseName(course_name);
			result.setUserId(user_id);
			result.setUserName(user_name);

			// call the resultService to save the result
			resultService.saveResult(result);

			model.addAttribute("result", result);
			submitted = true;
		} else {
			return "redirect:/";
		}

		return "showResult";
	}

	// This method will show all courses for user to choose to see all result
	// belongs to that course
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showAllCourseResult(Model model) {
		// Get list course
		List<Course> courses = new ArrayList<>();
		courses = courseService.getAllCourse();

		model.addAttribute("courses", courses);
		return "listCourseResultForUser";
		
	}
	
	// This method will show list result for user
	@RequestMapping(value = "/result/get", method = RequestMethod.GET)
	public String showResult(@RequestParam(name = "course_id") int courseId, Model model) {
		// Get logged user information
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		
		// Get user detail information by userName
		User user = new User();
		user = userService.getUserByEmail(userName);
		
		//get user ID
		int userId = user.getId();
		
		// Get list result by course id and user id
		List<Result> results = new ArrayList<>();
		results = resultService.getResultByCourseIdAndUserId(courseId, userId);
		
		model.addAttribute("results",results);
		return "listResultForUser";
	}

}
