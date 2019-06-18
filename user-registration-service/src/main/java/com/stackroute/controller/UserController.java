package com.stackroute.controller;


import com.stackroute.domain.User;
import com.stackroute.userservice.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;





@RestController

@RequestMapping (value = "api/v1")
public class UserController {
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }





    @PostMapping ("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
    }

}

