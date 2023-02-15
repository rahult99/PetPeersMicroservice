package com.petproject_apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/DBServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "DB Service is taking longer than Expected." + " Please try again later";
	}

	@GetMapping("/UserServiceFallBack")
	public String employeeServiceFallBackMethod() {
		return "User Service is taking longer than Expected." + " Please try again later";
	}
}