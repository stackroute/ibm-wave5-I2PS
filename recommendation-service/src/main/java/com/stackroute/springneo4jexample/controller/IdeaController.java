package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.service.IdeaService;
import com.stackroute.springneo4jexample.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/idea")
public class IdeaController {

    @Autowired
    IdeaService ideaService;


    //to get list of all ideas
    @GetMapping("/getall")
    public Collection<Idea> getAll() {

        return ideaService.getAll();
    }

    //To save idea
    @PostMapping("/saved")
    public ResponseEntity<?> savedIdea(@RequestBody Idea idea)
    {
        ideaService.saved(idea);
        return new ResponseEntity<Idea>(ideaService.saved(idea), HttpStatus.CREATED);
    }

    //To match subDomain and ideaName
    @PostMapping("/{subDomainName}/{ideaName}")
    public  Idea getIdeaSubDomain(@PathVariable String subDomainName,@PathVariable String ideaName){

        return ideaService.matchSubDomain(subDomainName,ideaName);
    }



    @GetMapping("getIdea/{role}")
    public List<Idea> getIdea(@PathVariable String role) {
        return ideaService.getIdea(role);


    }
    @GetMapping("ideas/{emailId}")
    public List<Idea> getRecommendedIdeas(@PathVariable String emailId){
        return ideaService.getRecommendedIdeas(emailId);
    }

}
