package com.accolite.msau.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.msau.dao.CourseDao;
import com.accolite.msau.models.Course;


@SpringBootTest()
public class CourseServiceTest {

	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	

	@InjectMocks
	private CourseService courseService;
	
	@Mock
	private CourseDao courseDao;

	@BeforeEach
	public void init() {
		course1.setCourseId(1);
		course1.setDescription("AI course");
		course1.setLocation("Mumbai");
		course1.setName("MLAI");
		course1.setPrerequisites("Python");
		course1.setSkills("Machine Learning");
		course1.setCreatorId(1);
		
		course2.setCourseId(2);
		course2.setDescription("Full Stack course");
		course2.setLocation("Banglore");
		course2.setName("Angular Spring");
		course2.setPrerequisites("Java");
		course2.setSkills("Web Dev");
		course2.setCreatorId(1);
		
		courses.add(course1);
		courses.add(course2);
	}
	
	@Test
	public void getAllCourses() {
		Mockito.when(courseDao.getAllCourse()).thenReturn(courses);
		assertEquals(courses, courseService.getAllCourse());
	}
	
	@Test
	public void getCourseById() {
		Mockito.when(courseDao.getCourseById(1)).thenReturn(course1);
		assertEquals(course1,courseService.getCourseById(1));
	}

	@Test
	public void getCourseOfCreator() {
		Mockito.when(courseDao.getCourseOfCreator(1)).thenReturn(courses);
		assertEquals(courses,courseService.getCourseOfCreator(1));
	}


	@Test
	public void updateCourse() {
		Mockito.when(courseDao.updateCourse(course1)).thenReturn("COURSE UPDATED SUCCESSFULLY");
		assertEquals("COURSE UPDATED SUCCESSFULLY",courseService.updateCourse(course1));
	}

	@Test
	public void deleteCourse() {
		Mockito.when(courseDao.deleteCourse(1)).thenReturn("COURSE DELETED SUCCESSFULLY");
		assertEquals("COURSE DELETED SUCCESSFULLY",courseService.deleteCourse(1));
	}

	@Test
	public void addCourse() {
		Mockito.when(courseDao.addCourse(course1)).thenReturn("COURSE CREATED SUCCESSFULLY");
		assertEquals("COURSE CREATED SUCCESSFULLY",courseService.addCourse(course1));
	}
	
}
