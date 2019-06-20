package com.stackroute.controller;


import com.stackroute.domain.User;


import com.stackroute.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;







@RestController

@RequestMapping (value = "api/v1")
public class UserController {

    UserServiceImpl userServiceImpl;


    @Autowired
    public UserController(UserServiceImpl userServiceImpl)
    {
        this.userServiceImpl=userServiceImpl;
    }



    @GetMapping(value = "/producer")
    public String producer(@RequestParam("userName") String userName, @RequestParam("password") String password) {

        User user=new User();
//        user.setUserName("khushbu");
//        user.setPassword("kk");
        userServiceImpl.send(user);

        return "Message sent to the hiiiiiiii RabbitMQ Successfully";
    }



    @PostMapping ("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        userServiceImpl.send(user);
        return new ResponseEntity<User>(userServiceImpl.saveUser(user),HttpStatus.CREATED);
    }

}

