package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SubDomainRepository extends Neo4jRepository<SubDomain,Long> {

    @Query("MATCH (u:SubDomain) RETURN u")
    Collection<SubDomain> getAllNode();

    @Query("CREATE (u:SubDomain) SET u.id={id},u.subDomainName={subDomainName} RETURN u")
    SubDomain createNode(Long id, String subDomainName);

    @Query("MATCH (a:User),(b:SubDomain) WHERE a.subDomain = {subDomain} AND b.subDomainName = {subDomainName} CREATE (a)-[r:WORK]->(b) RETURN r")
    SubDomain relation(String subDomain, String subDomainName);

    @Query("MATCH (a:Idea),(b:SubDomain) WHERE a.subDomain = {subDomain} AND b.subDomainName = {subDomainName} CREATE (a)-[r:is_of]->(b) RETURN r")
    SubDomain ideaRelationship(String subDomain, String subDomainName);


    @Query("MATCH  (u:User)-[r:WORKED_UPON]->(i:Idea)-[:is_of]->(:SubDomain)<-[:is_of]-(m:Idea) CREATE (m)-[c:recommend]->(u) RETURN c")
    SubDomain ideaRecommend(String userName);
//
//    @Query("MATCH (u:User),(b:SubDomain),(i:Idea) WHERE (u.name={userName}) AND (u:User)-[:WORKED_UPON]->(i:Idea)-[:is_of]->(:SubDomain)<-[:is_of]-(m:Idea) CREATE (m)-[c:recommend]->(u) RETURN c")
//    SubDomain ideaRecommend(String userName);
}
