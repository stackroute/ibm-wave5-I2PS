package com.stackroute.userservice;

import com.stackroute.domain.User;


import java.util.Optional;

public interface UserService {


    public Optional<User> getUser(int id);

}
