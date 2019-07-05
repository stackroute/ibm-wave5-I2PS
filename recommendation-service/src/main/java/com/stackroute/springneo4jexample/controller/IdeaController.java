package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/idea")
public class IdeaController {

    @Autowired
    IdeaService ideaService;

    @GetMapping("/getall")
    public Collection<Idea> getAll() {

        return ideaService.getAll();
    }

    @PostMapping("/save")
    public Idea saveIdea(@RequestBody Idea idea) {

        return ideaService.saveIdea(idea.getId(), idea.getIdeaName(),idea.getRole(),idea.getSubDomain());
    }

    @PutMapping("{ideaName}")
    public Idea updateIdea(@RequestBody Idea idea){
        return ideaService.updateUser(idea);
    }

    @GetMapping("{ideaName}")
    public  Idea getIdea(@PathVariable String ideaName){

        return ideaService.getByName(ideaName);
    }


    @DeleteMapping("{ideaName}")
    public String deleteUser(@PathVariable String ideaName) {
        ideaService.deleteUser(ideaName);
        return "Deleted User";
    }

    @PostMapping("/saved")
    public ResponseEntity<?> savedIdea(@RequestBody Idea idea)
    {
        ideaService.saved(idea);
        return new ResponseEntity<Idea>(ideaService.saved(idea), HttpStatus.CREATED);
    }

    @PostMapping("/{subDomainName}/{ideaName}")
    public  Idea getIdeaSubDomain(@PathVariable String subDomainName,@PathVariable String ideaName){

        return ideaService.matchSubDomain(subDomainName,ideaName);
    }




}
