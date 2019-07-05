package com.stackroute.springneo4jexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
@Component
public class Idea {
    @GraphId
    private Long id;
    private String ideaName;
    private List<String> role;
    private String subDomain;
    @Relationship(type = "is_of", direction = Relationship.OUTGOING)
    private SubDomain subDomainRel;

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", ideaName='" + ideaName + '\'' +
                ", role=" + role +
                ", subDomain='" + subDomain + '\'' +
                ", subDomainRel=" + subDomainRel +
                '}';
    }
}
