package com.accolite.msau.models;

import java.sql.Timestamp;

public class TrainingMaterial {


	private int trainingMaterialId;
	private int trainingId;
	private byte[] file;
	private String fileName;
	private String fileType;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	
	public int getTrainingMaterialId() {
		return trainingMaterialId;
	}
	public void setTrainingMaterialId(int trainingMaterialId) {
		this.trainingMaterialId = trainingMaterialId;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
//	@Override
//	public String toString() {
//		return "TrainingMaterial [trainingMaterialId=" + trainingMaterialId + ", trainingId=" + trainingId + ", file="
//				+ Arrays.toString(file) + ", fileType=" + fileType + ", createdOn=" + createdOn + ", modifiedOn="
//				+ modifiedOn + "]";
//	}
		
}
