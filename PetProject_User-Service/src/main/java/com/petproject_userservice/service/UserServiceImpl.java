package com.petproject_userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject_userservice.model.Pet;
import com.petproject_userservice.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PetFeignClient petFeignClient;

	@Autowired
	private UserFeignClient userFeignClient;

	
	
	// *****************************************************************************************************
	// Available-Pet() Operation.

	@Override
	public List<Pet> availablePets() {

		List<Pet> pets = petFeignClient.dtofindAllPet();

		List<Pet> sortedPets = new ArrayList<Pet>();

		String compareVar = "Available";

		for (Pet pet : pets) {
			// System.out.println(pet.getPetName());
			if (pet.getPetStatus().equals(compareVar)) {

				sortedPets.add(pet);

			}
		}

		return sortedPets;
	}

	// *****************************************************************************************************
	// BUY-Pet() Operation.

	@Override

	public int buyPet(int userIdKey, int petIdKey) {

		int tempVar = 0;
		Pet tempPet = null;

		// PetServiceIntf petServiceIntf = new PetServiceImpl();

		User targetUser = userFeignClient.dtoFindUserById(userIdKey);
		Pet targetPet = petFeignClient.dtoFindPetById(petIdKey);
		
		System.out.println("------------------------------------------");
		System.out.println(targetPet.getPetName());
		System.out.println("------------------------------------------");
		// List<Pet> petsList = new ArrayList<Pet>();

		String compareVar = "Available";

		if (targetPet.getPetStatus().equals(compareVar)) {

			targetPet.setPetStatus("Sold");
			targetPet.setUser(targetUser);

			tempPet = petFeignClient.dtoupdatePet(targetPet);

			// petsList.add(targetPet);

			// targetUser.setPets(petsList);
			// tempUser = updateUser(targetUser);

			if (tempPet != null) {
				tempVar = 1;
			}
		} else {
			tempVar = 2;
		}

		return tempVar;
	}

	// *****************************************************************************************************
	// findAllUserPets() Operation.

	@Override

	public List<Pet> findAllUserPets(int userIdKey) {

		// User tempUser = findUserById(userIdKey);

		// List<Pet> tempPets = tempUser.getPets();

		User tempUser = null;

		List<Pet> tempPets = petFeignClient.dtofindAllPet();

		List<Pet> ownedPets = new ArrayList<Pet>();

		for (Pet pet : tempPets) {

			tempUser = pet.getUser();

			if (tempUser != null) {
				System.out.println(tempUser.getUserId() + " " + userIdKey);
				if (tempUser.getUserId() == userIdKey) {

					System.out.println("Comparing");
					ownedPets.add(pet);
				}
			}
		}

		return ownedPets;
	}

}
