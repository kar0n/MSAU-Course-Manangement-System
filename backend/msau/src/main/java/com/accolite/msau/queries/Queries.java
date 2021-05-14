package com.accolite.msau.queries;

public class Queries {

	private Queries() {}
	
// USER Queries
	
	public static final String GET_ALL_USERS = 		"SELECT * FROM user";
	public static final String GET_USER_BY_EMAIL = 	"SELECT * FROM user WHERE user_email = ?";
	public static final String GET_USER_BY_ID = 	"SELECT * FROM user WHERE user_id = ?";
	public static final String GET_USER_BY_NAME = 	"SELECT * FROM user WHERE user_name = ?";
	
	public static final String GET_ALL_STUDENTS = "SELECT * FROM user WHERE user_type='student' OR user_type='super'";
	public static final String GET_ALL_TRAINERS = "SELECT * FROM user WHERE user_type='trainer' OR user_type='super'";
	public static final String GET_ALL_CREATORS = "SELECT * FROM user WHERE user_type='creator' OR user_type='super'";
		
	// GET CREATOR OF A COURSE(ID)
	public static final String GET_COURSE_CREATOR = 		"SELECT * FROM user u INNER JOIN course c ON u.user_id = c.course_creator_id WHERE c.course_id = ?";
	// GET TRAINERS OF A COURSE
	public static final String GET_COURSE_TRAINER =			"SELECT * FROM user u INNER JOIN training t ON u.user_id = t.training_trainer_id WHERE t.training_course_id = ?";
	// GET ALL STUDENTS OF A PARTICULAR TRAINING SESSION(ID)
	public static final String GET_STUDENTS_IN_TRAINING = 	"SELECT * FROM user u,student_training_session st WHERE u.user_id = st.session_student_id and st.session_training_id = ?";
	// GET COUNT OF ALL STUDENTS OF A PARTICULAR TRAINING SESSION(ID)
	public static final String GET_STUDENTS_COUNT_IN_TRAINING = "SELECT COUNT(*) FROM user u,student_training_session st WHERE u.user_id = st.session_student_id and st.session_training_id = ?";
	
// COURSE Queries
	
	public static final String GET_ALL_COURSES = 	"SELECT * FROM course";
	public static final String GET_COURSE_BY_ID = 	"SELECT * FROM course WHERE course_id = ?";
	public static final String GET_COURSE_BY_NAME =	"SELECT * FROM course WHERE course_name = ?";
	public static final String CREATE_COURSE = 		"INSERT INTO course(course_name, course_description, course_prerequisites, course_skills, course_location, course_creator_id) VALUES (?,?,?,?,?,?)";
	public static final String UPDATE_COURSE = 		"UPDATE course SET course_name = ?, course_description = ?, course_prerequisites = ?, course_skills = ?, course_location = ?, course_creator_id = ? WHERE course_id = ?";
	public static final String DELETE_COURSE = 		"DELETE FROM course WHERE course_id = ?";
	
	// GET COURSES OF A CREATOR
	public static final String GET_COURSES_OF_CREATOR = 	"SELECT * FROM course WHERE course_creator_id = ?";
	// GET COURSES BY A TRAINER(ID)
	public static final String GET_COURSES_FOR_TRAINER = 	"SELECT * FROM course c INNER JOIN training t ON c.course_id = t.training_course_id WHERE t.training_trainer_id = ?";
	// GET TOTAL NUMBER OF COURSES
	public static final String GET_COURSE_COUNT = 			"SELECT COUNT(*) FROM course";

	public static final String GET_COUNT_LOCATION =  "SELECT course_location, COUNT(course_name) course_location FROM course GROUP BY course_location ORDER BY COUNT(course_name) DESC";
	public static final String GET_COUNT_SKILL =  "SELECT course_skills, COUNT(course_name) course_skills FROM course GROUP BY course_skills ORDER BY COUNT(course_skills) DESC";
// TRAINING Queries
	
	public static final String GET_ALL_TRAINING = "SELECT * FROM training";
	public static final String GET_TRAINING_BY_ID = "SELECT * FROM training WHERE training_id = ?";
	public static final String CREATE_TRAINING = "INSERT INTO training(training_datetime, training_trainer_id, training_course_id) VALUES (?, ?, ?)";
	public static final String UPDATE_TRAINING = "UPDATE training SET training_feedback = ? WHERE training_id = ?";
	public static final String DELETE_TRAINING = "DELETE FROM training WHERE training_id = ?";
	public static final String GET_TRAINING_FOR_TRAINER = "SELECT * FROM training WHERE training_trainer_id = ?";
	public static final String GET_TRAINING_FOR_STUDENT = "SELECT * FROM training t, student_training_session st WHERE st.session_training_id = t.training_id and st.session_student_id = ?";
// TRAINING MATERIAL Queries
	
	public static final String GET_ALL_TRAINING_MATERIAL = 		"SELECT * FROM training_material";
	public static final String GET_TRAINING_MATERIAL_BY_ID =	"SELECT * FROM training_material WHERE training_material_id = ?";
	public static final String CREATE_TRAINING_MATERIAL = 		"INSERT INTO training_material(training_material_file, training_material_name, training_material_type, training_material_training_id) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TRAINING_MATERIAL = 		"INSERT INTO training_material(training_material_file, training_material_name, training_material_type, training_material_training_id) VALUES (?, ?, ?, ?)";
	public static final String DELETE_TRAINING_MATERIAL = 		"DELETE FROM training_material WHERE training_material_id = ?";

	
	// GET ALL TRAINING MATERIAL FOR A PARTICULAR TRAINING
	public static final String GET_TRAINING_MATERIAL_OF_TRAINING = "SELECT * FROM training_material WHERE training_material_training_id = ? ORDER BY training_material_modified DESC LIMIT 1";

	public static final String GET_TRAINING_VERSIONS = "SELECT * FROM training_material WHERE training_material_training_id = ?";
}
