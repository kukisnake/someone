package com.someone.controller;

import com.someone.dto.HobbyDTO;
import com.someone.entity.Hobby;
import com.someone.entity.User;
import com.someone.repository.UserRepository;
import com.someone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping(path="/user")
	public @ResponseBody
	void addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		userService.addNewUser(name,email,password);
	}

	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}


	//na pozniej
	/*
	@GetMapping(path="/all_hobbies_for_user/")
	public @ResponseBody Iterable<Hobby> getAllHobbiesForUser(@RequestParam User user) {
		return hobbyRepository.findByUser(user);
	}*/



	@PostMapping(path="/users/{user_id}/hobby")
	public @ResponseBody String addHobbyForUser(@RequestBody HobbyDTO hobbyDto, @PathVariable Integer user_id) {

		Optional<User> userFromRepo = userRepository.findById(user_id);
		User user = userFromRepo.get();
		//addHobby(hobbyDto);
		Hobby createdHobby = new Hobby();
		List<Hobby> listOfHobbies = user.getHobbies();
		listOfHobbies.add(createdHobby);
		user.setHobbies(listOfHobbies);
		userRepository.save(user);
		return user.toString();

		//return "Saved hobby for user";
	}






}
