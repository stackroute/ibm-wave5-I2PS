package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.domain.IdeaDTO;
import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.model.SubDomain;
import com.stackroute.springneo4jexample.repository.IdeaRepository;
import com.stackroute.springneo4jexample.repository.SubDomainRepository;
import com.stackroute.springneo4jexample.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class IdeaServiceImplementation implements IdeaService {

    @Autowired
    IdeaRepository ideaRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Idea idea;
    @Autowired
    UserRepository userRepository;


    @Override
    public Collection<Idea> getAll() {
        return ideaRepository.getAllIdeas();
    }

    @Override
    public Idea saved(Idea idea) {
        return ideaRepository.save(idea);
    }

    @Override
    public Idea matchSubDomain(String subDomainName,String ideaName) {
        return ideaRepository.matchSubDomain(subDomainName,ideaName);
    }

    @Override
    public List<Idea> getIdea( String role) {
        return ideaRepository.ideaRoleRelationship(role);

    }


    @RabbitListener(queues = "${javainuse.idea.queue}")
    public void recievedMessage(IdeaDTO ideaDTO) {

        log.info("Received Message: " + ideaDTO);

        //this ideaDTO will have the properties need to set them and assign it to our domain objects to call the methods

        idea.setIdeaName(ideaDTO.getTitle());
        idea.setRole(ideaDTO.getRoles());
        idea.setSubDomain(ideaDTO.getSubDomain());
        System.out.println(ideaDTO.toString());
        ideaRepository.save(idea);
        log.info("ideaNode3 is created");

        ideaRepository.matchSubDomain(ideaDTO.getSubDomain(),ideaDTO.getTitle());
        log.info("relationship created");

        List<String> roleList= new ArrayList<>();
        roleList = ideaDTO.getRoles();
        for(int i=0;i<roleList.size();i++) {
           ideaRepository.ideaRoleRelationship(roleList.get(i));
        }
        log.info("relationship created");

    }

    @Override
    public List<Idea> getRecommendedIdeas(String emailId) {
       String role= userRepository.getRoleForUser(emailId);
       return ideaRepository.ideaRoleRelationship(role);
    }
}
