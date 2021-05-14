package com.accolite.msau.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.msau.controllers.CourseController;
import com.accolite.msau.models.Course;
import com.accolite.msau.services.CourseService;

@SpringBootTest()
@AutoConfigureMockMvc
public class CourseControllerTest {

	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private CourseController courseController;
	
	@Mock
	private CourseService courseService;

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
	public void getAllCourse() throws Exception {
		
		when(courseService.getAllCourse()).thenReturn(courses);
		assertEquals(courses,courseController.getAllCourses());
		mockMvc.perform(get("/api/course/all")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void getCourseById() throws Exception {
		when(courseService.getCourseById(1)).thenReturn(course1);
		assertEquals(course1,courseController.getCourseById(1));
		mockMvc.perform(get("/api/course/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void getCourseOfCreator() throws Exception {
		when(courseService.getCourseOfCreator(1)).thenReturn(courses);
		
		mockMvc.perform(get("/api/course/creator/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	
	@Test
	public void addCourse() throws Exception {
		when(courseService.addCourse(course1)).thenReturn("Course Added Successfully");
		assertEquals("Course Added Successfully",courseController.addCourse(course1));

	}
	
	@Test
	public void updateCourse() throws Exception {
		when(courseService.updateCourse(course1)).thenReturn("Course Updated Successfully");
		assertEquals("Course Updated Successfully",courseController.updateCourse(course1));

	}
	
	@Test
	public void deleteCourse() {
		when(courseService.deleteCourse(1)).thenReturn("Course Deleted Successfully");
		assertEquals("Course Deleted Successfully",courseController.deleteCourse(1));
	}
	

}
