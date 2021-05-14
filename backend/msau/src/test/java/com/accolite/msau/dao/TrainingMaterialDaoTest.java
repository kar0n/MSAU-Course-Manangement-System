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
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.models.TrainingMaterial;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.TrainingMaterialRowMapper;

@SpringBootTest()
public class TrainingMaterialDaoTest {

	
	@InjectMocks
	private TrainingMaterialDao trainingMaterialDao;

	@Mock
    private JdbcTemplate jdbcTemplate;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	
	@BeforeEach
	public void init() {
		byte[] CDRIVES = hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d");
		trainingMaterial.setTrainingMaterialId(1);
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setTrainingId(1);
		
		trainingMaterial.setFile(CDRIVES);
		
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}

//	@Test
//	public void addFiles() throws Exception {
//		MultipartFile[] file = null;
//		byte[] test = null;
//		when(jdbcTemplate.update(Queries.CREATE_TRAINING_MATERIAL, 1, new javax.sql.rowset.serial.SerialBlob(test), file.length+"", file.length+"")).thenReturn(1);
//		assertEquals("File Added Successfully",trainingMaterialDao.addFiles(file,1));
//	}


	@Test
	public void deleteFile() {
		when(jdbcTemplate.update(Queries.DELETE_TRAINING_MATERIAL, 1)).thenReturn(1);
		assertEquals("FILE DELETED SUCCESSFULLY",trainingMaterialDao.deleteFiles(1));
	}

	@Test
	public void getFilesByTrainingId() {
		when(jdbcTemplate.queryForObject(Queries.GET_TRAINING_MATERIAL_OF_TRAINING, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, 1)).thenReturn(trainingMaterial);
		assertEquals(trainingMaterial,trainingMaterialDao.getTrainingMaterialByTrainingId(1));
	}

	@Test
	public void getVersions() {
		when(jdbcTemplate.query(Queries.GET_TRAINING_VERSIONS, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, 1)).thenReturn(list);
		assertEquals(list,trainingMaterialDao.getAllTrainingMaterialVersions(1));
	}
	
}