package com.stackroute.intelligentservice.repository;

import com.stackroute.intelligentservice.domain.IntelligentService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface IntelligentServiceRepository extends MongoRepository<IntelligentService,String> {

//    @Query
    Collection<IntelligentService> getByRole(String role);


}
