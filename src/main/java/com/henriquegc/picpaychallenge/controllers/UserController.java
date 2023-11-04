package com.henriquegc.picpaychallenge.controllers;

import com.henriquegc.picpaychallenge.domain.user.User;
import com.henriquegc.picpaychallenge.dtos.UserDTO;
import com.henriquegc.picpaychallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public void createUser(@RequestBody UserDTO user) {
        this.userService.createUser(user);
    }

    @GetMapping()
    public List<User> listUsers() {
        return this.userService.getUsers();
    }
}
