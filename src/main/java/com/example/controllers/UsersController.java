package com.example.controllers;

import com.example.models.Users;
import com.example.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/users")
    List<Users> findAllUsers(){
        return usersRepository.findAll();
    }
    @GetMapping("/users/{id}")
    private Users getByid(@PathVariable("id")long id){
        Optional<Users> users = usersRepository.findById(id);
        return users.get();
    }
}
