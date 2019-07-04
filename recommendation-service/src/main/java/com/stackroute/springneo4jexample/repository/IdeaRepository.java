package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

public interface IdeaRepository extends Neo4jRepository<Idea,Long> {
    @Query("MATCH (u:Idea) RETURN u")
    Collection<Idea> getAllIdeas();

    @Query("CREATE (u:Idea) SET u.id={id},u.ideaName={ideaName},u.role={role},u.subDomain={subDomain} RETURN u")
    Idea createNode(Long id, String ideaName, String role,String subDomain);

    @Query("MATCH (u:Idea) WHERE u.ideaName={ideaName} RETURN u")
    Idea getNode(@Param("ideaName") String ideaName);

    @Query("MATCH (n:Idea) WHERE n.ideaName={ideaName} DETACH DELETE n RETURN 'node deleted' ")
    void deleteNode(@Param("ideaName") String ideaName);
}
