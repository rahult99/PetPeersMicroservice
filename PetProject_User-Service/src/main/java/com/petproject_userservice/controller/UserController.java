package com.petproject_userservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petproject_userservice.model.Pet;
import com.petproject_userservice.model.User;
import com.petproject_userservice.service.UserFeignClient;
import com.petproject_userservice.service.UserService;



@RestController
@RequestMapping(value = "api/User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFeignClient userFeignClient;

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Create-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@PostMapping(value = "AddUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		return userFeignClient.addUser(user);
		
	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Find-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@GetMapping(value = "FindUser/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable("userId") int userIdKey) {

		return userFeignClient.findUserById(userIdKey);
	}

	@GetMapping(value = "AllUser")
	public ResponseEntity<List<User>> findAllUser() {

		return userFeignClient.findAllUser();

	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Update-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@PutMapping(value = "UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {

		return userFeignClient.updateUser(user);

	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Delete-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@DeleteMapping(value = "DeleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userIdKey) {

		return userFeignClient.deleteUser(userIdKey);
		
	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = => Show List of All Available Pets Rest End Point <== = = = = = = = = = = =

	@GetMapping(value = "AvailablePets")
	public ResponseEntity<List<Pet>> allAvailablePets() {

		ResponseEntity<List<Pet>> responseEntity;

		responseEntity = new ResponseEntity<List<Pet>>(userService.availablePets(), HttpStatus.OK);

		return responseEntity;
	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => BUY-PET Rest End Point <= = = = = = = = = = = = = = = = = =

	@PutMapping(value = "BuyPet/{userId}/{petId}")
	public ResponseEntity<String> buyPet(@PathVariable("userId") int userIdKey, @PathVariable("petId") int petIdKey) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;

		if (userIdKey > 0 && petIdKey > 0) {

			int buyPetResult = userService.buyPet(userIdKey, petIdKey);

			if (buyPetResult == 1) {
				tempMesasge = "Pet Successfully Bought.";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
			}
			if (buyPetResult == 2) {
				tempMesasge = "Not Available, Pet is already Sold !!.";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} else {
			tempMesasge = "User ID and Pet ID cannot be 0 or Smaller than 0.";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = => List of Pets owned by User Rest End Point <= = = = = = = = = = = = = =

	@GetMapping(value = "MyPets/{userId}")
	public ResponseEntity<List<Pet>> ownedPets(@PathVariable("userId") int userIdKey) {

		return new ResponseEntity<List<Pet>>(userService.findAllUserPets(userIdKey), HttpStatus.OK);

	}

}
