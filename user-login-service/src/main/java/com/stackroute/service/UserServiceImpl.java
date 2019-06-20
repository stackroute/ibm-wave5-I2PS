package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl() {
    }

    @Override
    public User findByNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }
}
