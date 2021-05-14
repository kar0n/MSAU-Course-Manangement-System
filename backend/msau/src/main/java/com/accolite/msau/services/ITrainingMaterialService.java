package com.accolite.msau.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.models.TrainingMaterial;

public interface ITrainingMaterialService {
	
//	public List<TrainingMaterial> getAllTrainingMaterials();
	
	public String addFiles(MultipartFile[] files, int trainingId) throws IOException, SQLException;
	
//	public TrainingMaterial getTrainingMaterialById(int materialId);
	
	public TrainingMaterial getTrainingMaterialByTrainingId(int trainingId);
	
	public List<TrainingMaterial> getTrainingMaterialVersions(int trainingId);
	
//	public String updateFiles(TrainingMaterial trainingMaterial);
	
	public String deleteFiles(int trainingMaterialId);

}
