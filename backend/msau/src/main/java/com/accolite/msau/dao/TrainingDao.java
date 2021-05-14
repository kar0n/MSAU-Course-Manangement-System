package com.accolite.msau.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.msau.models.Training;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.TrainingRowMapper;

@Repository
public class TrainingDao implements ITrainingDao {

	
	private static final Logger log = LoggerFactory.getLogger(TrainingDao.class);

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Training> getTrainingForTrainer(int trainerId) {
		List<Training> t = null;
		try {
			t =  jdbcTemplate.query(Queries.GET_TRAINING_FOR_TRAINER, TrainingRowMapper.TrainingRowMapperLambda, trainerId);
		} catch(Exception e) {
			log.error("{}",e);
		}
		return t;
	}
	
	
	@Override
	public String addTraining(Training training) {
		try {
			jdbcTemplate.update(
					Queries.CREATE_TRAINING,
					training.getDatetime(), 
					training.getTrainerId(),
					training.getCourseId()
					);
		}catch(Exception e) {
			log.error("{}",e);
			return "ERROR CREATING THE TRAINING";
		}
		
		return "TRAINING CREATED SUCCESSFULLY";
	}

	@Override
	public String updateTaining(Training training) {
		try {
			jdbcTemplate.update(
					Queries.UPDATE_TRAINING,
					training.getFeedback(),
					training.getTrainingId()
					);
		}catch(Exception e) {
			log.error("{}",e);
			return "ERROR UPDATING THE TRAINING";
		}
		return "TRAINING UPDATED SUCCESSFULLY";
	}

	@Override
	public List<Training> getTrainingForStudent(int studentId) {
		List<Training> t = null;
		try {
			t =  jdbcTemplate.query(Queries.GET_TRAINING_FOR_STUDENT, TrainingRowMapper.TrainingRowMapperLambda, studentId);
		} catch(Exception e) {
			log.error("{}",e);
		}
		return t;
	}

}
