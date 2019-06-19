package com.stackroute.userservice;

import com.stackroute.domain.User;


import java.util.Optional;

public interface UserService {

    User findByNameAndPassword(String name,String password);

}
