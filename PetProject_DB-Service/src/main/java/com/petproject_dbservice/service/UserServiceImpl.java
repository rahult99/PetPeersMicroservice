package com.petproject_dbservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject_dbservice.dao.UserDao;
import com.petproject_dbservice.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// *****************************************************************************************************
	// Find All() Operation.

	@Override
	public List<User> findAllUsers() {

		return userDao.findAll();

	}

	// *****************************************************************************************************
	// CRUD Operations :

	// *****************************************************************************************************
	// Create() Operation.

	@Override
	public User addUser(User user) {

		return userDao.save(user);

	}

	// *****************************************************************************************************
	// Read() Operation.

	@Override
	public User findUserById(int userIdKey) {

		User tempUser = null;

		Optional<User> userVar = userDao.findById(userIdKey);

		if (userVar.isPresent()) {
			tempUser = userVar.get();
		}

		return tempUser;
	}

	// *****************************************************************************************************
	// Update() Operation.

	@Override
	public User updateUser(User user) {

		return userDao.save(user);

	}

	// *****************************************************************************************************
	// Delete() Operation.

	@Override
	public int deleteUserByID(int userIdKey) {

		userDao.deleteById(userIdKey);
		return userIdKey;
	}

	/*// *****************************************************************************************************
	// Login User() Operation.

	@Override
	public User loginUser(User user) {

		User tempUser = null;

		User checkUser = findUserById(user.getUserId());

		if (user.getUserPassword().equals(checkUser.getUserPassword())) {
			tempUser = checkUser;
		}

		return tempUser;
	}

	// *****************************************************************************************************
	// BUY-Pet() Operation.

	@Override

	public int buyPet(int userIdKey, int petIdKey) {

		int tempVar = 0;
		Pet tempPet = null;

		// PetServiceIntf petServiceIntf = new PetServiceImpl();

		User targetUser = findUserById(userIdKey);
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
	}*/

}
