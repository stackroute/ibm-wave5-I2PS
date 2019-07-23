package com.stackroute.recommendationservice.repository;

import com.stackroute.recommendationservice.model.Idea;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
import java.util.List;

public interface IdeaRepository extends Neo4jRepository<Idea,Long> {

    //query to get all ideas
    @Query("MATCH (u:Idea) RETURN u")
    Collection<Idea> getAllIdeas();

    //Query to create relationship between idea and subDomain
    @Query("MATCH (n:Idea),(s:SubDomain) WHERE s.subDomainName={subDomainName}  AND n.ideaName={ideaName} CREATE (n)-[r:is_of]->(s)RETURN r")
    Idea matchSubDomain(@Param("subDomainName") String subDomainName,@Param("ideaName") String ideaName);


    //Query to retrieve ideas having specific role
    @Query("MATCH (n:Idea) \n" +
            "WHERE any(x IN n.role WHERE x ={role})\n" +
            "RETURN n")
    List<Idea> ideaRoleRelationship(@Param("role")String role);

    @Query("MATCH (n:Idea),(u:User) WHERE n.ideaName={ideaName} AND u.name={name} CREATE (u)-[r:applied]->(n)RETURN r")
    Idea userIdeaRelationship(@Param("ideaName")String ideaName,@Param("name")String name);

    //Query to recommend ideas
    @Query("MATCH  (u:User)-[r:applied]->(i:Idea)-[:is_of]->(:SubDomain)<-[:is_of]-(m:Idea) WHERE  u.emailId={emailId} CREATE (m)-[c:recommend]->(u) RETURN m")
    List<Idea> ideaRelationship(String emailId);
}
