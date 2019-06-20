package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    UserRepository userRepository;



    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public void send(User user) {
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
        System.out.println("Send msg = " + user);
    }



}