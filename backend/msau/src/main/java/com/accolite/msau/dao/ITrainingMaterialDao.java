package com.accolite.msau.dao;

import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.models.TrainingMaterial;

public interface ITrainingMaterialDao {
	
//	public List<TrainingMaterial> getAllTrainingMaterials();
	
	public String addFiles(MultipartFile[] files, int trainingId) throws IOException, SQLException;
	
//	public TrainingMaterial getTrainingMaterialById(int materialId);
	
	public TrainingMaterial getTrainingMaterialByTrainingId(int trainingId);
	
//	public String updateFiles(TrainingMaterial trainingMaterial);
	
	public String deleteFiles(int trainingMaterialId);
	
	public List<TrainingMaterial> getAllTrainingMaterialVersions(int trainingId);
	
	
}
