package com.accolite.msau.services;

import java.util.List;

import javax.mail.MessagingException;

import com.accolite.msau.models.Email;
import com.accolite.msau.models.Training;


public interface ITrainingService {

//	public List<Training> getAllTrainings();
	 
//	public Training getTrainingById(int trainingId);
	
	public List<Training> getTrainingForTrainer(int trainerId);
	
	public List<Training> getTrainingForStudent(int studentId);
	 
	public String addTraining(Training training);
	 
	public String updateTaining(Training trainingId);
	 
//	public String deleteTraining(int trainingId);
	
	public String sendMail(Email obj) throws MessagingException;
	 
}
