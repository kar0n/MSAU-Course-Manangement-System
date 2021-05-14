package com.accolite.msau.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.accolite.msau.models.Course;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.CourseRowMapper;

@Repository
public class CourseDao implements ICourseDao{

	
	private static final Logger log = LoggerFactory.getLogger(CourseDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Course> getAllCourse() {
		List<Course> c = null;
		try {
			c = jdbcTemplate.query(Queries.GET_ALL_COURSES, CourseRowMapper.CourseRowMapperLambda);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return c;
	}

	@Override
	public Course getCourseById(int courseId) {
		Course c = null;
		try {
			c = jdbcTemplate.queryForObject(Queries.GET_COURSE_BY_ID, CourseRowMapper.CourseRowMapperLambda, courseId);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return c;
	}
	
	@Override
	public List<Course> getCourseOfCreator(int creatorId) {
		List<Course> c = null;
		try {
			c = jdbcTemplate.query(Queries.GET_COURSES_OF_CREATOR, CourseRowMapper.CourseRowMapperLambda, creatorId);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return c; 
	}

	@Override
	public String addCourse(Course course) {
		try {
			jdbcTemplate.update(
					Queries.CREATE_COURSE,
					course.getName(), course.getDescription(), course.getPrerequisites(), course.getSkills(), course.getLocation(),
					course.getCreatorId()
					);
		}catch(Exception e) {
			log.error("{}", e);
			return "ERROR CREATING THE COURSE";
		}
		
		return "COURSE CREATED SUCCESSFULLY";
	}

	@Override
	public String updateCourse(Course course) {
		try {
			jdbcTemplate.update(
					Queries.UPDATE_COURSE,
					course.getName(), course.getDescription(), course.getPrerequisites(), course.getSkills(), course.getLocation(),
					course.getCreatorId(), course.getCourseId()
					);
		}catch(Exception e) {
			log.error("{}", e);
			return "ERROR UPDATING THE COURSE";
		}
		
		return "COURSE UPDATED SUCCESSFULLY";
	}

	@Override
	public String deleteCourse(int courseId) {
		try {
			jdbcTemplate.update(Queries.DELETE_COURSE, courseId);
		}catch(Exception e) {
			log.error("{}", e);
			return "ERROR CREATING THE COURSE";
		}
		
		return "COURSE DELETED SUCCESSFULLY";
	}


	@Override
	public List<Map<String, String>> getLocationCount() {
		
		List<Map<String,String>> item = new ArrayList<>();
		jdbcTemplate.query(Queries.GET_COUNT_LOCATION, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				Map<String,String> temp1 = new HashMap<>();
				temp1.put("name",resultSet.getString(1));
				temp1.put("value", resultSet.getString(2));
				item.add(temp1);
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
			}
		});
		
		return item;
	}
		

	@Override
	public List<Map<String, String>> getSkillsCount() {
		List<Map<String,String>> item = new ArrayList<>();
		jdbcTemplate.query(Queries.GET_COUNT_SKILL, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				Map<String,String> temp1 = new HashMap<>();
				temp1.put("name",resultSet.getString(1));
				temp1.put("value", resultSet.getString(2));
				item.add(temp1);
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
			}
		});
		
		return item;
	}
}
