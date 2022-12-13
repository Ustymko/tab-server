package com.example.postgrestest.controller;

import com.example.postgrestest.entity.User;
import com.example.postgrestest.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    @RequestMapping(value = "/post")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping
    @RequestMapping(value = "/get/{id}")
    public Optional<User> getById(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @PutMapping
    @RequestMapping(value = "/put/{id}")
    public void update(@PathVariable Integer id, @RequestBody User user){
        User newUser = userRepository.getById(id);
        newUser.setUsername(user.getUsername());
        newUser.setIsBot(user.getIsBot());
        userRepository.save(newUser);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        userRepository.deleteById(id);
    }
}
