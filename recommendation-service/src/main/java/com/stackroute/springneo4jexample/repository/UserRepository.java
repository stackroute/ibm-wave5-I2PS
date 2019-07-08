package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("CREATE (u:User) SET u.name={name},u.subDomain={subDomain},u.role={role} RETURN u")
     public User createNode( String name,List<String> subDomain,String role);

    @Query("MATCH (u:User),(i:Idea) WHERE {u.subDomain={subDomain}} CREATE (u)[r:WORKOn]->(i) RETURN r")
    public User createRelatonship(List<String> subDomain);


    @Query("MATCH (n:User) WHERE n.name={userName} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userName") String UserName);

    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u.role")
    public String getNode(@Param("userName") String userName);

    @Query("MATCH (u:User) WHERE u.emailId={emailId} RETURN u.role")
    public String getRoleForUser(@Param("emailId") String emailId);

    @Query("MATCH (u:User),(i:Idea)  WHERE u.idea=({idea}) AND i.ideaName={ideaName} CREATE(u)-[:WORKED_UPON]->(i);")
    public User createRelations( String idea,String ideaName);


    @Query("MATCH (u:User) WHERE u.subDomain={subDomain} RETURN u")
    Collection<User> getAllUserDomain(@Param("subDomain")String subDomain);



    @Query("MATCH (u:User),(i:Role)  WHERE u.role=({userRole}) AND i.roleName={roleName} CREATE(u)-[:is_a]->(i);")
    User createRoles( String userRole, String roleName);

    @Query("MATCH (u:User),(i:Idea) where i.ideaName=({ideaName}) match(u)<-[:hasIdea]-(i) RETURN u LIMIT 1000")

    List<User> findByIdea(String ideaName);

    //method to create relationship between user and subDomain
    @Query("MATCH (n:User),(s:SubDomain) WHERE s.subDomainName={subDomainName}  AND n.name={name} CREATE (n)-[r:work_on]->(s)RETURN r")
    User matchUserSubDomain(@Param("subDomainName") String subDomainName,@Param("name") String name);

    @Query("MATCH (n:User),(u:Role) WHERE u.roleName={roleName} AND n.name={name} CREATE (n)-[r:is_a]->(u)RETURN r")
    User matchRole(String roleName, String name);

    //@Query("MATCH (r:Role)<-[:is_a]-(u:User)-[:work_on]->(s:SubDomain)AND (i:Idea)-[:has_a]->(r:Role) RETURN i")


}
