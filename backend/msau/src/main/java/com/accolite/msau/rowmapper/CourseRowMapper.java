package com.accolite.msau.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.msau.constants.Attributes;
import com.accolite.msau.models.Course;

public class CourseRowMapper {
	
	private CourseRowMapper() {}
	
	public static final RowMapper<Course> CourseRowMapperLambda = (rs, rowNum) -> {
		
		Course course = new Course();
		
		course.setCourseId(rs.getInt(Attributes.COURSE_ID));
		course.setName(rs.getString(Attributes.COURSE_NAME));
		course.setDescription(rs.getString(Attributes.COURSE_DESCRIPTION));
		course.setLocation(rs.getString(Attributes.COURSE_LOCATION));
		course.setSkills(rs.getString(Attributes.COURSE_SKILLS));
		course.setPrerequisites(rs.getString(Attributes.COURSE_PREREQUISITES));
		course.setCreatedOn(rs.getTimestamp(Attributes.COURSE_CREATED));
		course.setModifiedOn(rs.getTimestamp(Attributes.COURSE_MODIFIED));
		course.setCreatorId(rs.getInt(Attributes.COURSE_CREATOR_ID));
		
		return course;
		
		
	};
	
}
