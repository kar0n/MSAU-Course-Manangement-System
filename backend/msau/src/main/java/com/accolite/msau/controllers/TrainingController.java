package com.accolite.msau.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.msau.models.Email;
import com.accolite.msau.models.Training;
import com.accolite.msau.services.TrainingService;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

	@Autowired
	TrainingService trainingService;
	
	@GetMapping("/trainer/{id}")
	public List<Training> getTrainingForTrainer(@PathVariable("id") int id){
		return trainingService.getTrainingForTrainer(id);
	}

	@GetMapping("/student/{id}")
	public List<Training> getTrainingForStudent(@PathVariable("id") int id){
		return trainingService.getTrainingForStudent(id);
	}
	
	@PostMapping("/add")
	public String addTraining(@RequestBody Training training) {
		return trainingService.addTraining(training);
	}
	
	@PostMapping("/update")
	public String updateTaining(@RequestBody Training trainingId) {
		return trainingService.updateTaining(trainingId);
	}
	
	@PostMapping("/mail")
	public String sendMail(@RequestBody Email obj) throws MessagingException {
		return trainingService.sendMail(obj);
	}
}
