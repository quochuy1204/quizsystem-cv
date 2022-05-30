package com.quizsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizsystem.model.Course;
import com.quizsystem.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}
	
	public List<Course> getAllCourse(){
		List<Course> courses = new ArrayList<>();
		courses = courseRepository.findAll();
		return courses;
	}
	
	public Course getCourseById(int id) {
		Course course = new Course();
		course = courseRepository.getById(id);
		return course;
	}
	
	public void deleteCourseById(int id) {
		courseRepository.deleteById(id);
	}
	
	
}
