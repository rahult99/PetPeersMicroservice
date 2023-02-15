package com.petproject_userservice.service;

import java.util.List;

import com.petproject_userservice.model.Pet;

public interface UserService {
	
	// *****************************************************************************************************
	// Available-Pet() Operation.
	
	public abstract List<Pet> availablePets();
	
	// *****************************************************************************************************
	// BUY-Pet() Operation.

	public abstract int buyPet(int userIdKey, int petIdKey);

	// *****************************************************************************************************
	// findAllUserPets() Operation.

	public List<Pet> findAllUserPets(int userIdKey);

}
