package com.stackroute.controller;


import com.stackroute.domain.Idea;
import com.stackroute.service.IdeaHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IdeaHubController {

    private IdeaHubService ideaHubService;


    @Autowired
    public IdeaHubController(IdeaHubService ideaService) {

        this.ideaHubService = ideaService;
    }

    @PostMapping("/addIdea")
    public ResponseEntity<Idea> addIdea(@RequestBody Idea idea) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dddd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        dateFormat.format(date);
        idea.setTimestamp(date);

        ideaHubService.send(idea);
        Idea addedIdea= ideaHubService.addIdea(idea);
        ideaHubService.send(idea);
        return new ResponseEntity<Idea>(addedIdea, HttpStatus.CREATED);
    }

    @GetMapping("/ideas")
    public ResponseEntity<List<Idea>> getIdeas()
    {
        return new ResponseEntity<List<Idea>>(ideaHubService.displayIdea(), HttpStatus.OK);
    }


    @DeleteMapping("/deleted/{ideaId}")
    public  ResponseEntity<String> deleteIdea(@PathVariable String ideaId)
    {
        ideaHubService.deleteIdea(ideaId);
        return new ResponseEntity<String>("successfully deleted",HttpStatus.GONE);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateIdea(@RequestBody Idea idea){
        System.out.println("idea updated");

        return new ResponseEntity<Idea>( ideaHubService.updateIdea(idea),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getIdeaByEmailId/{emailId}")
    public ResponseEntity<?> getByEmailId(@PathVariable String emailId)
    {
        return new ResponseEntity<>(ideaHubService.getByEmailId(emailId), HttpStatus.OK);


    }

}