package com.stackroute.jwt;

import com.stackroute.domain.User;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenrator
{
    Map<String, String> generateToken(User user);
}
