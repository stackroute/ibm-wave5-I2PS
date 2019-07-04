package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IdeaServiceImplementation implements IdeaService {

    @Autowired
    IdeaRepository ideaRepository;

    @Override
    public Collection<Idea> getAll() {
        return ideaRepository.getAllIdeas();
    }

    @Override
    public Idea saveIdea(Long id, String ideaName, String role,String subDomain) {
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
}
