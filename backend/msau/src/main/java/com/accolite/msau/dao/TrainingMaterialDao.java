package com.accolite.msau.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.models.TrainingMaterial;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.TrainingMaterialRowMapper;

@Repository
public class TrainingMaterialDao implements ITrainingMaterialDao {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addFiles(MultipartFile[] files, int trainingId) throws IOException, SQLException {
		try {
			
			for(MultipartFile file : files) {
				byte[] bytes = file.getBytes();
				Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
				jdbcTemplate.update(Queries.CREATE_TRAINING_MATERIAL, blob, file.getOriginalFilename(), file.getContentType(), trainingId);		}
			
		}catch(Exception e) {
			log.error("{}", e);
			return "ERROR ADDING/UPDATING FILES";
		}
		return "FILES ADDED SUCCESSFULLY";
		
	}

	@Override
	public TrainingMaterial getTrainingMaterialByTrainingId(int trainingId) {
		TrainingMaterial tm = null;
		try {
			tm = jdbcTemplate.queryForObject(Queries.GET_TRAINING_MATERIAL_OF_TRAINING, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, trainingId);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return tm;
	}

	@Override
	public List<TrainingMaterial> getAllTrainingMaterialVersions(int trainingId) {
		List<TrainingMaterial> tm = null;
		try {
			tm = jdbcTemplate.query(Queries.GET_TRAINING_VERSIONS, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, trainingId);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return tm;
	}
	

	@Override
	public String deleteFiles(int trainingMaterialId) {
		try {
			jdbcTemplate.update(Queries.DELETE_TRAINING_MATERIAL, trainingMaterialId);
		}catch(Exception e) {
			log.error("{}", e);
			return "ERROR DELETING THE FILE";
		}
		
		return "FILE DELETED SUCCESSFULLY";
	}

	
}
