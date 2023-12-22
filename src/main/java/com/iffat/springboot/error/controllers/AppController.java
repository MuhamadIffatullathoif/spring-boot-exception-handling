package com.iffat.springboot.error.controllers;

import com.iffat.springboot.error.exceptions.UserNotFoundException;
import com.iffat.springboot.error.models.domain.User;
import com.iffat.springboot.error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        // int value = 100/0;
        int value = Integer.parseInt("Halo");
        System.out.println(value);
        return "200 OK";
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not exists"));
        return user;
    }
}
