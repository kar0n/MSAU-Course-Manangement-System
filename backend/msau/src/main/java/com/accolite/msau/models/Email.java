package com.accolite.msau.models;


public class Email {
	
	private String emailId;
	private String emailSubject;
	private String courseName;
	private String trainerName;
	private String courseLocation;
	private String courseSkills;
	private String coursePrerequisites;
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	private String courseDescription;
	private String datetime;
	
	public String getEmailId() {
		return emailId;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	public String getCourseSkills() {
		return courseSkills;
	}
	public void setCourseSkills(String courseSkills) {
		this.courseSkills = courseSkills;
	}
	public String getCoursePrerequisites() {
		return coursePrerequisites;
	}
	public void setCoursePrerequisites(String coursePrerequisites) {
		this.coursePrerequisites = coursePrerequisites;
	}
	
//	@Override
//	public String toString() {
//		return "Email [emailId=" + emailId + ", emailSubject=" + emailSubject + ", courseDescription=" + courseDescription
//				+ ", courseName=" + courseName + ", trainerName=" + trainerName + ", courseLocation=" + courseLocation
//				+ ", courseSkills=" + courseSkills + ", coursePrerequisites=" + coursePrerequisites + "]";
//	}
}
