package com.stackroute.service;
import java.util.List;
import com.stackroute.domain.Idea;
public interface IdeaHubService
{
        Idea addIdea(Idea idea);
        void deleteIdea(String ideaId);
        Idea updateIdea(Idea idea);
        List<Idea> displayIdea();
        public void send(Idea idea);
    }

