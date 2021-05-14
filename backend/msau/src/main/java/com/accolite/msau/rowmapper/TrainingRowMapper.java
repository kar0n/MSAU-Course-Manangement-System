package com.accolite.msau.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.msau.constants.Attributes;
import com.accolite.msau.models.Training;

public class TrainingRowMapper {

	public static final RowMapper<Training> TrainingRowMapperLambda = (rs, rowNum) -> {
		
		Training training = new Training();
		
		training.setTrainingId(rs.getInt(Attributes.TRAINING_ID));
		training.setFeedback(rs.getString(Attributes.TRAINING_FEEDBACK));
		training.setDatetime(rs.getString(Attributes.TRAINING_DATETIME));
		training.setCreatedOn(rs.getTimestamp(Attributes.TRAINING_CREATED));
		training.setModifiedOn(rs.getTimestamp(Attributes.TRAINING_MODIFIED));
		training.setCourseId(rs.getInt(Attributes.TRAINING_COURSE_ID));
		training.setTrainerId(rs.getInt(Attributes.TRAINING_TRAINER_ID));
		
		return training;
	};
}
