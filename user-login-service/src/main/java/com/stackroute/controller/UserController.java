package com.stackroute.controller;


import com.stackroute.domain.User;
import com.stackroute.userservice.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* @RestController = @Controller + @ResponseBody */



@RestController

@RequestMapping (value = "api/v1")
public class UserController {
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }





    @GetMapping ("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return new ResponseEntity<Optional<User>>(userService.getUser(id),HttpStatus.OK);
    }

}

