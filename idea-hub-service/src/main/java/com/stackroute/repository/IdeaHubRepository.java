package com.stackroute.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaHubRepository extends MongoRepository<com.stackroute.domain.Idea,String> {
        @Override
        boolean existsById(String s);
    }

