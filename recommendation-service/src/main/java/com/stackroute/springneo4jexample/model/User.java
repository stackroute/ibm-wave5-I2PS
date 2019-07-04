package com.stackroute.springneo4jexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
@Component
public class User {

    @GraphId
    private Long id;
    private String emailId;
//    private String password;
    private String name;

    private List<String> subDomain;
    private String role;
   // private  List<String> skills;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", subDomain=" + subDomain +
                ", role='" + role + '\'' +
                '}';
    }
}
