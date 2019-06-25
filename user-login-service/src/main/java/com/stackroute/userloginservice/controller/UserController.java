package com.stackroute.userloginservice.controller;

import com.stackroute.userloginservice.service.UserServiceImpl;
import com.stackroute.userloginservice.domain.User;

import com.stackroute.userloginservice.exception.PasswordNotMatchException;
import com.stackroute.userloginservice.exception.UserNameNotFoundException;
import com.stackroute.userloginservice.exception.UserNameOrPasswordEmptyException;
import com.stackroute.userloginservice.jwt.SecurityTokenGenrator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/* @RestController = @Controller + @ResponseBody */

@CrossOrigin(value = "*")
@RequestMapping("api/v1")
@RestController
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?>  login(@RequestBody User loginDetails) throws UserNameOrPasswordEmptyException, UserNameNotFoundException, PasswordNotMatchException{

        String userName = loginDetails.getUserName();
//        String role=loginDetails.getRole();
        String password = loginDetails.getPassword();


        if (userName == null || password == null) {

            throw new UserNameOrPasswordEmptyException();
        }

        User user = userService.findByNameAndPassword(userName,password);

        if (user == null) {
            throw new UserNameNotFoundException();
        }

//        if(role==null)
//        {
//            throw new RoleNotFoundException();
//        }

        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new PasswordNotMatchException();
        }

        // generating token

        SecurityTokenGenrator securityTokenGenrator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId(""+user.getUserName()).setIssuedAt(new Date()) //.setSubject(user.getRole())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;

        };
        Map<String, String> map = securityTokenGenrator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

}

