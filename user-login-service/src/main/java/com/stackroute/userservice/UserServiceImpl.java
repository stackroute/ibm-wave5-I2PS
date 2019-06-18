package com.stackroute.userservice;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;


    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }
}
