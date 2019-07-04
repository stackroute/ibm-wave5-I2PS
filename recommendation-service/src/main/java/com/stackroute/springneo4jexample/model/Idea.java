package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Idea {
    @GraphId
    private Long id;
    private String ideaName;
    private String role;
    private String subDomain;

    public Idea(Long id, String ideaName , String role,String subDomain) {
        this.id = id;
        this.ideaName = ideaName;
        this.role = role;
        this.subDomain=subDomain;
    }

    public Idea() {
    }

    public Long getId() {
        return id;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public String getIdeaName() {
        return ideaName;
    }

    public String getRole() {
        return role;
    }
}
