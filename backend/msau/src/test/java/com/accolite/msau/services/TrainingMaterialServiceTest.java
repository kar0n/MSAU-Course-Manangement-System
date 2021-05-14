package com.accolite.msau.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.dao.TrainingMaterialDao;
import com.accolite.msau.models.TrainingMaterial;

@SpringBootTest()
public class TrainingMaterialServiceTest {

	@InjectMocks
	private TrainingMaterialService trainingMaterialService;

	@Mock
	private TrainingMaterialDao trainingMaterialDao;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		trainingMaterial.setTrainingMaterialId(1);
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setTrainingId(1);
		
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}
	
	@Test
	public void addFiles() throws Exception {
		MultipartFile[] file = null;
		
		Mockito.when(trainingMaterialDao.addFiles(file,1)).thenReturn("File Added Successfully!");
		assertEquals("File Added Successfully!",trainingMaterialService.addFiles(file, 1));
	}
	
	@Test
	public void getFilesByTrainingId() {
		Mockito.when(trainingMaterialDao.getTrainingMaterialByTrainingId(1)).thenReturn(trainingMaterial);
		assertEquals(trainingMaterial, trainingMaterialService.getTrainingMaterialByTrainingId(1));
	}
	
	@Test
	public void getTrainingMaterialVersions() {
		Mockito.when(trainingMaterialDao.getAllTrainingMaterialVersions(1)).thenReturn(list);
		assertEquals(list,trainingMaterialService.getTrainingMaterialVersions(1));
	}
	
	@Test
	public void deleteFile() {
		Mockito.when(trainingMaterialDao.deleteFiles(1)).thenReturn("File Deleted");
		assertEquals("File Deleted",trainingMaterialService.deleteFiles(1));
	}
	
	
}
