package com.petproject_dbservice.service;

import java.util.List;

import com.petproject_dbservice.model.User;

public interface UserService {

	//*****************************************************************************************************
	// Find All() Operation.

	public abstract List<User> findAllUsers();

	//*****************************************************************************************************
	// CRUD Operations :

	//*****************************************************************************************************
	// Create() Operation.

	public abstract User addUser(User user);

	//*****************************************************************************************************
	// Read() Operation.

	public abstract User findUserById(int userIdKey);

	//*****************************************************************************************************
	// Update() Operation.

	public abstract User updateUser(User user);

	//*****************************************************************************************************
	// Delete() Operation.

	public abstract int deleteUserByID(int userIdKey);

	/*//*****************************************************************************************************
	// Login User() Operation.

	public abstract User loginUser(User user);

	//*****************************************************************************************************
	// BUY-Pet() Operation.

	public abstract int buyPet(int userIdKey, int petIdKey);

	//*****************************************************************************************************
	// findAllUserPets() Operation.

	public List<Pet> findAllUserPets(int userIdKey);*/




	}
