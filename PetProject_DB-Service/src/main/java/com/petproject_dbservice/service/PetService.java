package com.petproject_dbservice.service;

import java.util.List;

import com.petproject_dbservice.model.Pet;


public interface PetService {
	
	//*****************************************************************************************************
	// Find All() Operation.
	
	public abstract List<Pet> findAllPets();
	
	//*****************************************************************************************************
	// CRUD Operations : 
			
	//*****************************************************************************************************
	// Create() Operation.
	
	public abstract Pet addPet(Pet pet);
	
	//*****************************************************************************************************
	// Read() Operation.
	
	public abstract Pet findPetByID(int petIdKey);
	
	//*****************************************************************************************************
	// Update() Operation.
	
	public abstract Pet updatePet(Pet pet);
	
	//*****************************************************************************************************
	// Delete() Operation.
	
	public abstract int deletePetByID(int petIdKey);


}

