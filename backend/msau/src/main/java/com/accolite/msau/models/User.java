package com.accolite.msau.models;

import java.sql.Blob;
import java.sql.Timestamp;


public class User {
	
	private int userId;
	private String type;
	private String name;
	private String email;
	private String location;
	private String designation;
	private Blob image;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
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
//		return "User [userId=" + userId + ", type=" + type + ", name=" + name + ", email=" + email + ", location="
//				+ location + ", designation=" + designation + ", image=" + image + ", createdOn=" + createdOn
//				+ ", modifiedOn=" + modifiedOn + "]";
//	}
	
	
}
