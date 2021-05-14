package com.accolite.msau.dao;

import java.util.List;

import com.accolite.msau.models.User;

public interface IUserDao {

//	public List<User> getAllUsers();
	
//	public User getUserById(int userId);
	
//	public User getUserByName(String userName);
	
	public User getUserByEmail(String userEmail);
	
//	public List<User> getAllStudents();
	
	public List<User> getAllTrainers();
	
	public List<User> getAllCreators();
	
//	public User getCourseCreator(int courseId);
	
//	public List<User> getCourseTrainer(int courseId);
	
//	public List<User> getStudentInTraining(int trainingId);
	
}
