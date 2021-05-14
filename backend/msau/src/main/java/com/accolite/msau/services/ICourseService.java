package com.accolite.msau.services;

import java.util.List;
import java.util.Map;

import com.accolite.msau.models.Course;

public interface ICourseService {

public List<Course> getAllCourse();
	
//	public List<Course> getCourseForTrainer(int trainerId);
	
	public List<Course> getCourseOfCreator(int creatorId);
	
	public Course getCourseById(int courseId);
	
//	public Course getCourseByName(String courseName);
	
	public String addCourse(Course course);
	
	public String updateCourse(Course course);
	
	public String deleteCourse(int courseId);
	
	public List<Map<String, String>> getLocationCount();
	
	public List<Map<String, String>> getSkillsCount();
	
}
