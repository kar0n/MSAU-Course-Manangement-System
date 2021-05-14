package com.accolite.msau.models;

import java.sql.Timestamp;

//@Entity
public class Course {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	private String name;
	private String description;
	private String skills;
	private String prerequisites;
	private String location;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	private int creatorId;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
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
//		return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description + ", skills=" + skills
//				+ ", prerequisites=" + prerequisites + ", location=" + location + ", createdOn=" + createdOn + 
//				", modifiedOn=" + modifiedOn + ", creatorId=" + creatorId + "]";
//	}
	
	
	
}
