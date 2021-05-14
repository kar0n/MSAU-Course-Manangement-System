package com.accolite.msau.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.controllers.TrainingMaterialController;
import com.accolite.msau.models.TrainingMaterial;
import com.accolite.msau.services.TrainingMaterialService;

@SpringBootTest()
@AutoConfigureMockMvc
public class TrainingMaterialControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private TrainingMaterialController trainingMaterialController;

	@Mock
	private TrainingMaterialService trainingMaterialService;

	
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
		
		Mockito.when(trainingMaterialService.addFiles(file,1)).thenReturn("File Added Successfully!");
		assertEquals("File Added Successfully!",trainingMaterialController.addFiles(file, 1));
	}
	
	@Test
	public void getFilesByTrainingId() throws Exception {
		Mockito.when(trainingMaterialService.getTrainingMaterialByTrainingId(1)).thenReturn(trainingMaterial);
		assertEquals(trainingMaterial, trainingMaterialController.getTrainingMaterialByTrainingId(1));
		mockMvc.perform(get("/api/trainingmaterial/training-files/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	
	@Test
	public void getTrainingMaterialVersions() throws Exception {
		Mockito.when(trainingMaterialService.getTrainingMaterialVersions(1)).thenReturn(list);
		assertEquals(list,trainingMaterialController.getTrainingMaterialVersions(1));
		mockMvc.perform(get("/api/trainingmaterial/training-files/versions/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void deleteFile() {
		Mockito.when(trainingMaterialService.deleteFiles(1)).thenReturn("File Deleted");
		assertEquals("File Deleted",trainingMaterialController.deleteFiles(1));
	}
	
	
	
}