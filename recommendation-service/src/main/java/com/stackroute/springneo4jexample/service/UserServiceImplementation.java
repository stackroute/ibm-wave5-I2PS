package com.stackroute.springneo4jexample.service;


import com.stackroute.springneo4jexample.domain.UserDTO;
import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;


@Slf4j
@Service
public class UserServiceImplementation implements UserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private  User user;


    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    @Override
    public User saveRelation(List<String> subDomain) {

            return userRepository.createRelatonship(subDomain);
        }
//
//    @Override
//    public User createRelation(Long id, String subDomain) {
//        return null;
//    }

    @Override
    public User saveUser(String name,List<String> subDomain,String role) {
        User savedUser=null;

        savedUser=userRepository.createNode(name,subDomain,role);
        return savedUser;

    }

    @Override
    public User getByName(String name) {
        return userRepository.getNode(name);
    }

    @Override
    public User createRelations(String idea,String ideaName) {
        return userRepository.createRelations(idea,ideaName);
    }




    @Override
    public void deleteUser(String name) {
        userRepository.deleteNode(name);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Collection<User> getAllUsersBy(String subDomain) {
        return userRepository.getAllUserDomain(subDomain);
    }

    @Override
    public User createRoles(String role, String roleName) {
        return userRepository.createRoles(role,roleName);
    }

    @Override
    public List<User> getAllUsers(String ideaName) {
        return userRepository.findByIdea(ideaName);
    }

    @Override
    public User saved(User user) {

        return userRepository.save(user);

    }


    @RabbitListener(queues = "${serviceNeo4j.queue}")
    public void recievedMessage(UserDTO userDTO) {
//        System.out.println("Recieved Message From service provider:" + userDTO.toString());
//        userRepository.createNode(userDTO.getEmailId(),userDTO.getPassword(),userDTO.getName(),userDTO.getDomain(),userDTO.getSubDomain(), userDTO.getRole(),userDTO.getSkills(),userDTO.getAbout(),userDTO.getExperience(),userDTO.getChargePerHour(),userDTO.getCertifications());

        log.info("Received Message: " + userDTO);

        /*
         * this userprofileDTO will have the properties need to set them and assign it to
         * our domain objects to call the methods
         * */



        user.setEmailId(userDTO.getEmailId());
        user.setName(userDTO.getName());
        user.setSubDomain(userDTO.getSubDomain());
        user.setRole(userDTO.getRole());
        userRepository.save(user);
        System.out.println(userDTO.toString());
        log.info("userNode3 is created");
    }

////this method creates relationship follows between userNode3 and topics
////        recommendationCommandServiceImpl.userFollowsTopic(userName, Name);
////        log.info("follows relationship is created");
//
//
////    @Override
////    public User saveRelation() {
////        return userRepository.createRelation();
////    }
//
//
//    }
}
