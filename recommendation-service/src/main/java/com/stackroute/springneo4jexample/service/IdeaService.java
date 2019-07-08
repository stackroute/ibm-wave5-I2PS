package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface IdeaService {

     Collection<Idea> getAll();

     Idea saved(Idea idea);

     Idea matchSubDomain(String subDomainName,String ideaName);

     List<Idea> getIdea(String role);

     List<Idea> getRecommendedIdeas(String emailId);
}
