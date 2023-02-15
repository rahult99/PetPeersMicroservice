package com.petproject_userservice.model;

/**
*
* @author Rahul
* 
*/

//Temporary User POJO File

public class User {

	private int userId;

	private String userName;
	private String userPassword;

	// Non-Parameterized Constructor
	public User() {
		super();
	}

	// Parameterized Constructor
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}


