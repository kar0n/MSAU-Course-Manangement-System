package com.accolite.msau.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.msau.controllers.TrainingController;
import com.accolite.msau.models.Email;
import com.accolite.msau.models.Training;
import com.accolite.msau.services.TrainingService;

@SpringBootTest()
@AutoConfigureMockMvc
public class TrainingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private TrainingController trainingController;

	
	@Mock
	private TrainingService trainingService;
	
	Training obj = new Training();
	List<Training> list = new ArrayList<>();
	Email mail = new Email();
	
	@BeforeEach
	public void init() {
		
		obj.setCourseId(1);
		obj.setFeedback("Great");
		obj.setTrainerId(1);
		obj.setTrainingId(3);
		
		
		mail.setEmailId("karan.shah@accolitedigital.com");
		mail.setEmailSubject("Accolite Mail System");
		mail.setCourseDescription("description");
		mail.setCourseLocation("Mumbai");
		mail.setCourseName("Angular");
		mail.setCoursePrerequisites("Prerequisites");
		mail.setCourseSkills("Skills");
		mail.setTrainerName("Karan");
		
		list.add(obj);
		list.add(obj);
	}
	
	
	
	@Test
	public void getTrainingForTrainer() throws Exception {
		Mockito.when(trainingService.getTrainingForTrainer(1)).thenReturn(list);
		assertEquals(list, trainingController.getTrainingForTrainer(1));
		mockMvc.perform(get("/api/training/trainer/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void getTrainingForStudent() {
		Mockito.when(trainingService.getTrainingForStudent(1)).thenReturn(list);
		assertEquals(list, trainingController.getTrainingForStudent(1));
	}

	
	@Test
	public void addTraining() throws Exception {
		when(trainingService.addTraining(obj)).thenReturn("Training Added Successfully");
		assertEquals("Training Added Successfully",trainingController.addTraining(obj));

	}
	
	@Test
	public void updateTraining() throws Exception {
		when(trainingService.updateTaining(obj)).thenReturn("Course Updated Successfully");
		assertEquals("Course Updated Successfully",trainingController.updateTaining(obj));

	}
	
	
	@Test
	public void sendMail() throws MessagingException {
		Mockito.when(trainingService.sendMail(mail)).thenReturn("Mail Sent");
		assertEquals("Mail Sent", trainingController.sendMail(mail));
	}

}