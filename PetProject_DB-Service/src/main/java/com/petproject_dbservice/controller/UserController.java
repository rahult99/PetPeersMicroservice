package com.petproject_dbservice.controller;

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

import com.petproject_dbservice.model.User;
import com.petproject_dbservice.service.UserService;



@RestController
@RequestMapping(value = "User")
public class UserController {
	
	@Autowired
	private UserService userService;

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Create-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@PostMapping(value = "AddUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity;

		if (user.getUserPassword().length() > 4) {

			User tempUser = userService.addUser(user);

			if (tempUser != null) {

				tempMesasge = "User Added Successfully";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);

			} 
			else 
			{
				tempMesasge = "Failed to Add User, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else 
		{

			tempMesasge = "Password must be greater than 4 Digits !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Find-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@GetMapping(value = "FindUser/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable("userId") int userIdKey) {

		return new ResponseEntity<User>(userService.findUserById(userIdKey), HttpStatus.OK);
	}

	@GetMapping(value = "AllUser")
	public ResponseEntity<List<User>> findAllUser() {

		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);

	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Update-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@PutMapping(value = "UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity;

		if (user.getUserPassword().length() > 4) {

			User tempUser = userService.updateUser(user);

			if (tempUser != null) {

				tempMesasge = "User Updated Successfully";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);

			} 
			else 
			{
				tempMesasge = "Failed to Update User, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else 
		{

			tempMesasge = "Password must be greater than 4 Digits !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;

	}

	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Delete-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@DeleteMapping(value = "DeleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userIdKey) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;

		if (userIdKey > 0) {

			User tempUser = userService.findUserById(userIdKey);

			if (tempUser != null) {

				int tempUserId = userService.deleteUserByID(userIdKey);

				String userIdString = Integer.toString(tempUserId);

				String tempMessage = "User with ID : " + userIdString + " is Deleted.";

				responseEntity = new ResponseEntity<String>(tempMessage, HttpStatus.OK);
			}
			else 
			{

				tempMesasge = "No such User Exists";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else
		{

			tempMesasge = "User-ID cannot be 0 OR Less Than 0 !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	/*// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => Login-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@PostMapping(value = "Login/{userId}/{userPassword}")
	public ResponseEntity<String> loginUser(@PathVariable("userId") int userIDKey,
			@PathVariable("userPassword") String userPasswordKey) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;

		User tempUser = new User();
		tempUser.setUserId(userIDKey);
		tempUser.setUserPassword(userPasswordKey);

		User loginResult = userService.loginUser(tempUser);

		if (loginResult != null) {

			tempMesasge = "Login Successfull ! Welcome " + loginResult.getUserName() + " to the Pet Shop Application.";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
		} 
		else 
		{
			tempMesasge = "Login Unsuccessfull, Please check ID and PassWord";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	*/
	
	// *****************************************************************************************************
	// = = = = = = = = = = = = = = = = = => DTO-Find-User Rest End Point <= = = = = = = = = = = = = = = = = =

	@GetMapping(value = "DTO/FindUser/{userId}")
	public User dtoFindUserById(@PathVariable("userId") int userIdKey) {

		return userService.findUserById(userIdKey);
	}

}
