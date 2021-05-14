package com.accolite.msau.constants;

public class Attributes {

	private Attributes() {}
	
	// TABLES
	public static final String USER							= "user";
	public static final String COURSE						= "course";	 
	public static final String TRAINING						= "training";
	public static final String STUDENT_TRAINING_SESSION 	= "student_training_session";
	public static final String TRAINING_MATERIAL			= "training_material";
	
	// USER TABLE
	public static final String USER_ID						= "user_id";
	public static final String USER_TYPE					= "user_type";
	public static final String USER_NAME					= "user_name";
	public static final String USER_EMAIL					= "user_email";
	public static final String USER_LOCATION				= "user_location";
	public static final String USER_DESIGNATION				= "user_designation";
	public static final String USER_IMAGE					= "user_image";
	public static final String USER_CREATED					= "user_created";
	public static final String USER_MODIFIED				= "user_modified";
	
	// COURSE TABLE
	public static final String COURSE_ID					= "course_id";
	public static final String COURSE_NAME					= "course_name";
	public static final String COURSE_DESCRIPTION			= "course_description";
	public static final String COURSE_PREREQUISITES			= "course_prerequisites";
	public static final String COURSE_SKILLS				= "course_skills";
	public static final String COURSE_LOCATION				= "course_location";
	public static final String COURSE_CREATED				= "course_created";
	public static final String COURSE_MODIFIED				= "course_modified";
	public static final String COURSE_CREATOR_ID			= "course_creator_id";
	
	// TRAINING TABLE
	public static final String TRAINING_ID					= "training_id";
	public static final String TRAINING_FEEDBACK			= "training_feedback";
	public static final String TRAINING_DATETIME			= "training_datetime";
	public static final String TRAINING_CREATED				= "training_created";
	public static final String TRAINING_MODIFIED			= "training_modified";
	public static final String TRAINING_TRAINER_ID			= "training_trainer_id";
	public static final String TRAINING_COURSE_ID			= "training_course_id";
	
	// TRAINING MATERIAL TABLE
	public static final String TRAINING_MATERIAL_ID				= "training_material_id";
	public static final String TRAINING_MATERIAL_FILE			= "training_material_file";
	public static final String TRAINING_MATERIAL_NAME			= "training_material_name";
	public static final String TRAINING_MATERIAL_TYPE			= "training_material_type";
	public static final String TRAINING_MATERIAL_CREATED		= "training_material_created";
	public static final String TRAINING_MATERIAL_MODIFIED		= "training_material_modified";
	public static final String TRAINING_MATERIAL_TRAINING_ID	= "training_material_training_id";
	
	// STUDENT TRAINING TABLE
	public static final String SESSION_STUDENT_ID			= "session_student_id";
	public static final String SESSION_TRAINING_ID			= "session_training_id";
}
