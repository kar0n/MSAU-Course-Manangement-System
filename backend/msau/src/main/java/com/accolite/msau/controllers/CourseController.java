package com.accolite.msau.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.msau.models.Course;
import com.accolite.msau.services.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/all")
	public List<Course> getAllCourses(){
		return courseService.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") int id) {
		return courseService.getCourseById(id);
	}
	
	@GetMapping("/creator/{id}")
	public List<Course> getCourseOfCreator(@PathVariable("id") int id) {
		return courseService.getCourseOfCreator(id);
	}
	
	@PostMapping("/add")
	public String addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PostMapping("/update")
	public String updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		return courseService.deleteCourse(id);
	}
	
	@GetMapping("/trends/location")
	public List<Map<String, String>> countLocation(){
		return courseService.getLocationCount();
	}
	
	@GetMapping("/trends/skills")
	public List<Map<String, String>> countSkills(){
		return courseService.getSkillsCount();
	}
	
	
}
