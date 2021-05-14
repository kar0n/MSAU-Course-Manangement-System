package com.accolite.msau.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accolite.msau.models.TrainingMaterial;
import com.accolite.msau.services.TrainingMaterialService;

@RestController
@RequestMapping("/api/trainingmaterial")
public class TrainingMaterialController {

	@Autowired
	TrainingMaterialService tmService;

	@PostMapping("/add")
	public String addFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("trainingId") int trainingId) throws IOException, SQLException {
		return tmService.addFiles(files, trainingId);
	}

	@GetMapping("/training-files/{trainingId}")
	public TrainingMaterial getTrainingMaterialByTrainingId(@PathVariable("trainingId") int trainingId) {
		return tmService.getTrainingMaterialByTrainingId(trainingId);
	}

	@GetMapping("training-files/versions/{trainingId}")
	public List<TrainingMaterial> getTrainingMaterialVersions(@PathVariable("trainingId") int trainingId){
		return tmService.getTrainingMaterialVersions(trainingId);
	}

	@DeleteMapping("/delete/{trainingMaterialId}")
	public String deleteFiles(@PathVariable("trainingMaterialId") int trainingMaterialId) {
		return tmService.deleteFiles(trainingMaterialId);
	}
}
