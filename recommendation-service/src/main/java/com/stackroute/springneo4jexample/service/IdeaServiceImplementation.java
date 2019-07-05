package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.domain.IdeaDTO;
import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.repository.IdeaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class IdeaServiceImplementation implements IdeaService {

    @Autowired
    IdeaRepository ideaRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Idea idea;

    @Override
    public Collection<Idea> getAll() {
        return ideaRepository.getAllIdeas();
    }

    @Override
    public Idea saveIdea(Long id, String ideaName, List<String> role, String subDomain) {
       Idea savedIdea=null;

        savedIdea=ideaRepository.createNode(id,ideaName,role,subDomain);
        return savedIdea;
    }

    @Override
    public Idea getByName(String ideaName) {
        return ideaRepository.getNode(ideaName);
    }

    @Override
    public void deleteUser(String ideaName) {

        ideaRepository.deleteNode(ideaName);
    }

    @Override
    public Idea updateUser(Idea idea) {
        return ideaRepository.save(idea);
    }

    @Override
    public Idea saved(Idea idea) {
        return ideaRepository.save(idea);
    }

    @Override
    public Idea matchSubDomain(String subDomainName,String ideaName) {
        return ideaRepository.matchSubDomain(subDomainName,ideaName);
    }


    @RabbitListener(queues = "${javainuse.idea.queue}")
    public void recievedMessage(IdeaDTO ideaDTO) {

        log.info("Received Message: " + ideaDTO);

        /*
         * this ideaDTO will have the properties need to set them and assign it to
         * our domain objects to call the methods
         * */
        idea.setIdeaName(ideaDTO.getTitle());
        idea.setRole(ideaDTO.getRoles());
        idea.setSubDomain(ideaDTO.getSubDomain());

        System.out.println(ideaDTO.toString());
        ideaRepository.save(idea);

        log.info("ideaNode3 is created");
        ideaRepository.matchSubDomain(ideaDTO.getSubDomain(),ideaDTO.getTitle());
        log.info("relationship created");
    }

}
