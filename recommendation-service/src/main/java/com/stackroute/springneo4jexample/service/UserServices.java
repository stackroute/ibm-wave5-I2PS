package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserServices {

    // User createRelation(Long id, String subDomain);

    public User saveUser(String userName, List<String> subDomain,String userRole  );

    public Collection<User> getAll();

    User saveRelation(List<String> subDomain);

   public void deleteUser(String name);

    public User updateUser(User user);

   public String getByName(String name);

    User createRelations(String idea,String ideaName);

   // public Collection<User> getAllUsers();

    Collection<User> getAllUsersBy(String subDomainName);

    User createRoles(String role, String roleName);

    public List<User> getAllUsers(String ideaName);

    User saved(User user);

    User matchUserSubDomain(String subDomainName, String name);


//    public void recivedMessage(User user);
////
//
//     public User saveRelation();
}
