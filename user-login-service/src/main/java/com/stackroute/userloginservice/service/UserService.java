package com.stackroute.userloginservice.service;

import com.stackroute.userloginservice.domain.User;

public interface UserService {

    User findByNameAndPassword(String userName,String password);

}
