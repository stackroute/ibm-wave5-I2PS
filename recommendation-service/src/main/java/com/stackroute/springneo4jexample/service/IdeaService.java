package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IdeaService {
    public Collection<Idea> getAll();

   public Idea saveIdea(Long id, String ideaName, String role,String subDomain);

    Idea getByName(String ideaName);

    void deleteUser(String ideaName);

    Idea updateUser(Idea idea);
}
