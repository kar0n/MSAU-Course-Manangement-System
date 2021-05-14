package com.accolite.msau.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.dao.TrainingMaterialDao;
import com.accolite.msau.models.TrainingMaterial;

@Service
public class TrainingMaterialService implements ITrainingMaterialService {

	@Autowired
	TrainingMaterialDao trainingmaterialdao;
	

	@Override
	public String addFiles(MultipartFile[] files, int trainingId) throws IOException, SQLException {
		return trainingmaterialdao.addFiles(files, trainingId);
	}


	@Override
	public TrainingMaterial getTrainingMaterialByTrainingId(int trainingId) {
		return trainingmaterialdao.getTrainingMaterialByTrainingId(trainingId);
	}
	
	@Override
	public List<TrainingMaterial> getTrainingMaterialVersions(int trainingId) {
		return trainingmaterialdao.getAllTrainingMaterialVersions(trainingId);
	}

	@Override
	public String deleteFiles(int trainingMaterialId) {
		return trainingmaterialdao.deleteFiles(trainingMaterialId);
	}

}
