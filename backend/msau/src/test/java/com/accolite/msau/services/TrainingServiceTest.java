package com.accolite.msau.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.msau.dao.TrainingDao;
import com.accolite.msau.models.Email;
import com.accolite.msau.models.Training;

@SpringBootTest()
public class TrainingServiceTest {

	@InjectMocks
	private TrainingService trainingService;

	
	@Mock
	private TrainingDao trainingDao;
	
	Training training = new Training();
	List<Training> list = new ArrayList<>();
	Email mail = new Email();
	
	@BeforeEach
	public void init() {
		
		training.setCourseId(1);
		training.setFeedback("Great");
		training.setTrainerId(1);
		training.setTrainingId(3);
		
		list.add(training);
		list.add(training);
		
		mail.setEmailId("abc@gmail.com");
		mail.setEmailSubject("Accolite Mail System");
		mail.setCourseDescription("desc");
		mail.setCourseLocation("Goa");
		mail.setCourseName("React");
		mail.setCoursePrerequisites("Prerequisites");
		mail.setCourseSkills("Skills");
		mail.setTrainerName("Karan");
	}
	
	@Test
	public void getTrainingForTrainer() {
		Mockito.when(trainingDao.getTrainingForTrainer(1)).thenReturn(list);
		assertEquals(list, trainingService.getTrainingForTrainer(1));
	}
	
	@Test
	public void getTrainingForStudent() {
		Mockito.when(trainingDao.getTrainingForStudent(1)).thenReturn(list);
		assertEquals(list, trainingService.getTrainingForStudent(1));
	}

	
	@Test
	public void addTraining() throws Exception {
		when(trainingDao.addTraining(training)).thenReturn("Training Added Successfully");
		assertEquals("Training Added Successfully",trainingService.addTraining(training));
	}
	
	@Test
	public void updateTraining() throws Exception {
		when(trainingDao.updateTaining(training)).thenReturn("Course Updated Successfully");
		assertEquals("Course Updated Successfully",trainingService.updateTaining(training));
	}
	
}
