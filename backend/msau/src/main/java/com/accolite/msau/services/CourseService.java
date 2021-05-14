package com.accolite.msau.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.msau.dao.CourseDao;
import com.accolite.msau.models.Course;

@Service
public class CourseService implements ICourseService {
	

	
	@Autowired
	CourseDao coursedao;

	@Override
	public List<Course> getAllCourse() {
			return coursedao.getAllCourse();
	}

	@Override
	public List<Course> getCourseOfCreator(int creatorId) {
		return coursedao.getCourseOfCreator(creatorId);
	}

	@Override
	public Course getCourseById(int courseId) {
		return coursedao.getCourseById(courseId);
	}

	@Override
	public String addCourse(Course course) {
		return coursedao.addCourse(course);
	}

	@Override
	public String updateCourse(Course course) {
		return coursedao.updateCourse(course);
	}

	@Override
	public String deleteCourse(int courseId) {
		return coursedao.deleteCourse(courseId);
	}

	@Override
	public List<Map<String, String>> getLocationCount() {
		return coursedao.getLocationCount();
	}

	@Override
	public List<Map<String, String>> getSkillsCount() {
		return coursedao.getSkillsCount();
	}
}
