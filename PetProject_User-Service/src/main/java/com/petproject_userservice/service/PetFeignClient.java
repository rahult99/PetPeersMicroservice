package com.petproject_userservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.petproject_userservice.model.Pet;

@FeignClient(name = "pfc", url = "http://localhost:8091/PetPeers/api/Pet")
public interface PetFeignClient {

	@GetMapping(value = "DTO/FindPet/{petId}")
	public abstract Pet dtoFindPetById(@PathVariable("petId") int petIdKey);

	@GetMapping(value = "DTO/AllPet")
	public abstract List<Pet> dtofindAllPet();

	@PutMapping(value = "DTO/UpdatePet")
	public Pet dtoupdatePet(@RequestBody Pet pet);

}
