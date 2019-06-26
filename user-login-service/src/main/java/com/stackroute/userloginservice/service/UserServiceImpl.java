package com.stackroute.userloginservice.service;

import com.stackroute.userloginservice.domain.User;
import com.stackroute.userloginservice.repository.UserRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByEmailIdAndPassword(String emailId, String password) {
        return userRepository.findByEmailIdAndPassword(emailId, password);
    }

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void recievedMessage(User user) {
        userRepository.save(user);
        System.out.println("Recieved Message From RabbitMQ:" + user.toString());

    }


}