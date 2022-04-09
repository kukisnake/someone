package com.someone.controller;

import com.someone.dto.HobbyDTO;
import com.someone.entity.Hobby;
import com.someone.repository.HobbyRepository;
import com.someone.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private HobbyService hobbyService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/hobbies")
    public @ResponseBody Iterable<Hobby> getAllUsers() {
        return hobbyRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/hobby")
    public @ResponseBody void addNewHobby(@RequestBody HobbyDTO hobbyDto) {
        hobbyService.addNewHobby(hobbyDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/hobby/{hobby_id}")
    public void deleteHobby(@PathVariable("hobby_id") Integer hobby_id) {
        hobbyRepository.deleteById(hobby_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/hobbies/{user_id}")
    public Iterable<Hobby> getAllHobbiesForUser(@PathVariable("user_id") Integer user_id) {
        return hobbyRepository.findByID(user_id);
    }
}
