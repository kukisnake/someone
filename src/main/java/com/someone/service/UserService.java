package com.someone.service;

import com.someone.entity.User;
import com.someone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addNewUser(String name, String email,  String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }
}
