package com.accolite.msau.models;

import java.sql.Timestamp;


public class Training {
	
	private int trainingId;
	private int courseId;
	private int trainerId;
	private String feedback;
	private String datetime;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
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
//		return "Training [trainingId=" + trainingId + ", courseId=" + courseId + ", trainerId=" + trainerId
//				+ ", feedback=" + feedback + ", datetime=" + datetime + ", createdOn=" + createdOn + ", modifiedOn="
//				+ modifiedOn + "]";
//	}
	
}
