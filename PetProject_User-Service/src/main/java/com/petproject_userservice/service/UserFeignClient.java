package com.petproject_userservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.petproject_userservice.model.User;


@FeignClient(name = "ufc", url = "http://localhost:8091/PetPeers/User")
public interface UserFeignClient {
	
	@PostMapping(value = "AddUser")
	public abstract ResponseEntity<String> addUser(@RequestBody User user);
	
	@GetMapping(value = "FindUser/{userId}")
	public abstract ResponseEntity<User> findUserById(@PathVariable("userId") int userIdKey);
	
	@GetMapping(value = "AllUser")
	public abstract ResponseEntity<List<User>> findAllUser();
	
	@PutMapping(value = "UpdateUser")
	public abstract ResponseEntity<String> updateUser(@RequestBody User user);
	
	@DeleteMapping(value = "DeleteUser/{userId}")
	public abstract ResponseEntity<String> deleteUser(@PathVariable("userId") int userIdKey);
	
	@GetMapping(value = "DTO/FindUser/{userId}")
	public abstract User dtoFindUserById(@PathVariable("userId") int userIdKey);

}
