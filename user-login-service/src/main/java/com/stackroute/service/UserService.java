package com.stackroute.service;

import com.stackroute.domain.User;

public interface UserService {

    User findByNameAndPassword(String userName,String password);

}
