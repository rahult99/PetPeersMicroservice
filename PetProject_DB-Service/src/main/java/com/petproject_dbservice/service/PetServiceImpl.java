package com.petproject_dbservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject_dbservice.dao.PetDao;
import com.petproject_dbservice.model.Pet;



@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetDao petDao;
	
	//*****************************************************************************************************
	// Find-All() Operation.
	
	@Override
	public List<Pet> findAllPets() {

		return petDao.findAll();
		
	}

	//*****************************************************************************************************
	// CRUD Operations : 
				
	//*****************************************************************************************************
	// Create() Operation.
	
	@Override
	public Pet addPet(Pet pet) {
		
		/*Pet tempPet = null;
		
		tempPet = petDaoIntf.save(pet);
		
		return tempPet;*/ 
		
		return petDao.save(pet);
		
	}

	//*****************************************************************************************************
	// Read() Operation.
	
	@Override
	public Pet findPetByID(int petIdKey) {
		
		Pet tempPet = null;
		
		Optional<Pet> petVar = petDao.findById(petIdKey);
		
		if (petVar.isPresent()) {
			
			tempPet = petVar.get();
			
		}
		
		return tempPet;
	}

	//*****************************************************************************************************
	// Update() Operation.
	
	@Override
	public Pet updatePet(Pet pet) {
	
		return petDao.save(pet);
		
	}

	//*****************************************************************************************************
	// Delete() Operation.
	
	@Override
	public int deletePetByID(int petIdKey) {
		

		petDao.deleteById(petIdKey);
		
		return petIdKey;
				
		/*Pet tempPet = findPetByID(petIdKey);
		
		if (tempPet.getPetId() > 0) {
			
			petDaoIntf.deleteById(petIdKey);
			
		}

		return petIdKey;*/
		
	}

}

