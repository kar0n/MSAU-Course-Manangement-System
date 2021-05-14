package com.accolite.msau.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.msau.models.Training;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.TrainingRowMapper;

@SpringBootTest()
public class TrainingDaoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private TrainingDao trainingDao;
	
	Training obj = new Training();
	List<Training> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		
		obj.setCourseId(1);
		obj.setFeedback("Great");
		obj.setTrainerId(1);
		obj.setTrainingId(3);
		
		list.add(obj);
		list.add(obj);
	}

	@Test
	public void addTraining() {
		when(jdbcTemplate.update(Queries.CREATE_TRAINING, obj.getDatetime(), obj.getTrainerId(), obj.getCourseId())).thenReturn(1);
		assertEquals("TRAINING CREATED SUCCESSFULLY",trainingDao.addTraining(obj));
	}


	@Test
	public void updateTraining() {
		when(jdbcTemplate.update(Queries.UPDATE_TRAINING, 1)).thenReturn(1);
		assertEquals("TRAINING UPDATED SUCCESSFULLY",trainingDao.updateTaining(obj));
	}

	@Test
	public void getTrainingForTrainer() {
		when(jdbcTemplate.query(Queries.GET_TRAINING_FOR_TRAINER, TrainingRowMapper.TrainingRowMapperLambda ,1)).thenReturn(list);
		assertEquals(list,trainingDao.getTrainingForTrainer(1));
	}

	@Test
	public void getTrainingForStudent() {
		when(jdbcTemplate.query(Queries.GET_TRAINING_FOR_STUDENT, TrainingRowMapper.TrainingRowMapperLambda ,1)).thenReturn(list);
		assertEquals(list,trainingDao.getTrainingForStudent(1));
	}
	
	
}
