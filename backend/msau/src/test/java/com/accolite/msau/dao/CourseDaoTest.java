package com.accolite.msau.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.msau.models.Course;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.CourseRowMapper;

@SpringBootTest()
public class CourseDaoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private CourseDao courseDao;

	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	
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
		course1.setCreatorId(1);
		
		courses.add(course1);
		courses.add(course2);
	}
	
	
	
	@Test
	public void getAllCourse() throws Exception {
			when(jdbcTemplate.query(Queries.GET_ALL_COURSES, CourseRowMapper.CourseRowMapperLambda ))
	          .thenReturn(courses);
	         List<Course> courses = (List<Course>) courseDao.getAllCourse();
	         assertEquals(2, courses.size());
	         
	}
	
	@Test
	public void getCourseById() throws Exception {
		
		when(jdbcTemplate.queryForObject(Queries.GET_COURSE_BY_ID, CourseRowMapper.CourseRowMapperLambda, 1 )).thenReturn(course1);
		
		Course courseFound = (Course) courseDao.getCourseById(1);
		assertEquals(course1, courseFound);
	}
	
	@Test
	public void addCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.CREATE_COURSE, course1.getDescription(), course1.getLocation(), course1.getName(), course1.getPrerequisites(), course1.getSkills(), course1.getCreatorId())).thenReturn(1);
		
		String courseFound = courseDao.addCourse(course1);
		assertThat(courseFound).isNotNull();
		assertEquals("COURSE CREATED SUCCESSFULLY", courseFound);
		
//		doThrow(new RuntimeException()).when(jdbcTemplate).update(Queries.CREATE_COURSE, course1.getDescription(), course1.getLocation(), course1.getName(), course1.getPrerequisites(), course1.getSkills(), course1.getCreatorId());
//		courseFound = courseDao.addCourse(course1);
//		assertEquals("ERROR CREATING THE COURSE", courseFound);
// 		verify(jdbcTemplate, times(2)).update(Queries.CREATE_COURSE, course1.getDescription(), course1.getLocation(), course1.getName(), course1.getPrerequisites(), course1.getSkills(), course1);
//		
	}
	
	@Test
	public void updateCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.UPDATE_COURSE, course1.getDescription(), course1.getLocation(), course1.getName(), course1.getPrerequisites(), course1.getSkills(), course1.getCourseId())).thenReturn(1);
		
		String courseFound = courseDao.updateCourse(course1);
		assertThat(courseFound).isNotNull();
		assertEquals("COURSE UPDATED SUCCESSFULLY", courseFound);
		
	}
	
	@Test
	public void deleteCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.DELETE_COURSE, 1)).thenReturn(1);
		
		String courseFound = courseDao.deleteCourse(1);
		assertThat(courseFound).isNotNull();
		assertEquals("COURSE DELETED SUCCESSFULLY", courseFound);
	}

	@Test
	public void getCourseOfCreator() throws Exception {
		
		when(jdbcTemplate.query(Queries.GET_COURSES_OF_CREATOR, CourseRowMapper.CourseRowMapperLambda, 2)).thenReturn(courses);

		List<Course> recdCourses = (List<Course>) courseDao.getCourseOfCreator(2);
		assertThat(recdCourses).isNotNull();
		assertEquals(2, recdCourses.size());
	}

}

